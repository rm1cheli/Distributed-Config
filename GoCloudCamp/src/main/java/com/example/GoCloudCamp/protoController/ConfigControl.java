package com.example.GoCloudCamp.protoController;

import com.example.GoCloudCamp.models.Config;
import com.example.GoCloudCamp.services.ConfigService;
import com.example.GoCloudCamp.services.ServiceService;
import com.example.grpc.ConfigServiceGrpc;
import com.example.grpc.GoService;
import com.google.protobuf.Empty;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;


@GrpcService
public class ConfigControl extends ConfigServiceGrpc.ConfigServiceImplBase {

    private final ConfigService configService;
    private final ServiceService serviceService;

    @Autowired
    public ConfigControl(ConfigService configService, ServiceService serviceService) {
        this.configService = configService;
        this.serviceService = serviceService;
    }

    @Override
    public void addConfig(GoService.Config request, StreamObserver<GoService.Response> responseObserver){
        if (request.getService().isEmpty() || request.getDataList().isEmpty() || serviceService.findByName(request.getService()).isEmpty())
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            Config config = new Config();
            config.setService(request.getService());
            config.setData(request.getDataList().stream()
                    .collect(Collectors.toMap(GoService.Data::getKey, GoService.Data::getValue)));
            Config old = configService.findByNameAndActive(config.getService(), true).orElse(null);
            if(old != null){
                old.setActive(false);
                config.setVersion(old.getVersion() + 1);
                configService.save(old);
            }
            config.setActive(true);
            configService.save(config);
            GoService.Response response = GoService.Response.newBuilder()
                    .setGreeting("OK")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getActiveConfig(GoService.ConfigName request, StreamObserver<GoService.Response> responseObserver) {
        if (request.getName().isEmpty()){
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        Config config = configService.findByNameAndActive(request.getName(), true).orElse(null);
        if (config == null)
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            GoService.Response response = GoService.Response.newBuilder().setGreeting(config.getData().toString()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getAllConfigs(Empty request, StreamObserver<GoService.AllConfigs> responseObserver) {
        List<Config> configs = configService.findAll();
        GoService.AllConfigs response = GoService.AllConfigs.newBuilder()
                .addAllConfigs(configs.stream().map(i ->{return GoService.Config.newBuilder()
                        .setService(i.getService())
                        .addAllData(i.getData().entrySet().stream()
                                .map(pair -> {return GoService.Data.newBuilder()
                                        .setKey(pair.getKey())
                                        .setValue(pair.getValue().toString()).build();})
                                .collect(Collectors.toList())).build();}).collect(Collectors.toList())).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getConfigVersion(GoService.ConfigNameAndVersion request, StreamObserver<GoService.Response> responseObserver) {
        if(request.getName().isEmpty()){
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        Config config = configService.findByNameAndVersion(request.getName(), request.getVersion()).orElse(null);
        if(config == null)
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            GoService.Response response = GoService.Response.newBuilder().setGreeting(config.getData().toString()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void updateConfig(GoService.Config request, StreamObserver<GoService.Response> responseObserver) {
        GoService.Response response = null;
        if (request.getService().isEmpty() || request.getDataList().isEmpty() || configService.findByName(request.getService()).isEmpty())
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            Config config = configService.findByNameAndActive(request.getService(), true).orElse(null);
            assert config != null;
            config.setData(request.getDataList().stream()
                    .collect(Collectors.toMap(GoService.Data::getKey, GoService.Data::getValue)));
            config.setServiceId(config.getServiceId());
            configService.update(config.getId(), config);
            response = GoService.Response.newBuilder()
                    .setGreeting("OK")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteConfig(GoService.ConfigNameAndVersion request, StreamObserver<GoService.Response> responseObserver) {
        if (request.getName().isEmpty()){
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        Config config = configService.findByNameAndVersion(request.getName(), request.getVersion()).orElse(null);
        if (config == null || config.isActive())
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            configService.delete(config);
            GoService.Response response = GoService.Response.newBuilder()
                    .setGreeting("OK")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}