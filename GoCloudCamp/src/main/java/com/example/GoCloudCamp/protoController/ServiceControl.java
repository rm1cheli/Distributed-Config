package com.example.GoCloudCamp.protoController;

import com.example.GoCloudCamp.models.Config;
import com.example.GoCloudCamp.models.Service;
import com.example.GoCloudCamp.services.ConfigService;
import com.example.GoCloudCamp.services.ServiceService;
import com.example.grpc.GoService;
import com.example.grpc.ServiceServiceGrpc;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@GrpcService
public class ServiceControl extends ServiceServiceGrpc.ServiceServiceImplBase {

    private final ServiceService serviceService;
    private final ConfigService configService;

    @Autowired
    public ServiceControl(ServiceService serviceService, ConfigService configService) {
        this.serviceService = serviceService;
        this.configService = configService;
    }

    @Override
    public void addService(GoService.Service request, StreamObserver<GoService.Response> responseObserver) {
        if(request.getName().isEmpty() || serviceService.findByName(request.getName()).isPresent())
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            Service service = new Service();
            service.setName(request.getName());
            serviceService.save(service);
            GoService.Response response = GoService.Response.newBuilder()
                    .setGreeting("OK")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getService(GoService.ServiceName request, StreamObserver<GoService.Response> responseObserver) {
        if (request.getName().isEmpty()) {
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        Service service = serviceService.findByName(request.getName()).orElse(null);
        if(service == null)
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            GoService.Response response = GoService.Response.newBuilder().setGreeting(service.getName()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getConfigsService(GoService.ServiceName request, StreamObserver<GoService.AllConfigs> responseObserver) {
        if(request.getName().isEmpty()){
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        Service service = serviceService.findByName(request.getName()).orElse(null);
        if(service == null)
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            List<Config> configs = configService.findAllByService(service.getName());
            GoService.AllConfigs allConfigs = GoService.AllConfigs.newBuilder().
                    addAllConfigs(configs.stream().map(i ->{return GoService.Config.newBuilder()
                            .setService(i.getService())
                            .addAllData(i.getData().entrySet().stream()
                                    .map(pair -> {return GoService.Data.newBuilder()
                                            .setKey(pair.getKey())
                                            .setValue(pair.getValue().toString()).build();})
                                    .collect(Collectors.toList())).build();}).collect(Collectors.toList())).build();
            responseObserver.onNext(allConfigs);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void getActiveConfig(GoService.ServiceName request, StreamObserver<GoService.Response> responseObserver) {
        if(request.getName().isEmpty()){
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
            return;
        }
        Service service = serviceService.findByName(request.getName()).orElse(null);
        Config config = configService.findByNameAndActive(request.getName(), true).orElse(null);
        if(service == null || config == null)
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            GoService.Response response = GoService.Response.newBuilder()
                    .setGreeting(config.getData().toString()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void deleteService(GoService.ServiceName request, StreamObserver<GoService.Response> responseObserver) {
        if(request.getName().isEmpty() || serviceService.findByName(request.getName()).isEmpty())
            responseObserver.onError(new StatusRuntimeException(Status.INVALID_ARGUMENT));
        else {
            Service service = new Service();
            service.setName(request.getName());
            serviceService.delete(service);
            GoService.Response response = GoService.Response.newBuilder()
                    .setGreeting("OK")
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}