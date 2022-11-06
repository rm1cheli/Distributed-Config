package com.example.Client;

import com.example.grpc.ConfigServiceGrpc;
import com.example.grpc.GoService;
import com.example.grpc.ServiceServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private static GoService.Config createConfig(){
        List<GoService.Data> data = new ArrayList<>();
        data.add(GoService.Data.newBuilder().setKey("key1").setValue("value1").build());
        data.add(GoService.Data.newBuilder().setKey("key2").setValue("value2").build());
        return GoService.Config.newBuilder().setService("managed-k8s").addAllData(data).build();
    }

    private static GoService.Config updateConfig(){
        List<GoService.Data> data = new ArrayList<>();
        data.add(GoService.Data.newBuilder().setKey("keyUp1").setValue("valueUp1").build());
        data.add(GoService.Data.newBuilder().setKey("keyUp2").setValue("valueUp2").build());
        return GoService.Config.newBuilder().setService("managed-k8s").addAllData(data).build();
    }

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .enableRetry().maxRetryAttempts(10).usePlaintext().build();
        ServiceServiceGrpc.ServiceServiceBlockingStub serviceStub = ServiceServiceGrpc.newBlockingStub(channel);
        ConfigServiceGrpc.ConfigServiceBlockingStub configStub = ConfigServiceGrpc.newBlockingStub(channel);
        GoService.Service service = GoService.Service.newBuilder().setName("managed-k8s").build();
        GoService.Response response;
        try {
            response = serviceStub.addService(service);
            System.out.println("Add Service: " + response.getGreeting());


            GoService.Config config = createConfig();
            response = configStub.addConfig(config);
            System.out.println("Add Config: " + response.getGreeting());


            response = configStub.getActiveConfig(GoService.ConfigName.newBuilder().setName(config.getService()).build());
            System.out.println("Config: " + response.getGreeting());


            config = updateConfig();
            response = configStub.updateConfig(config);
            System.out.println("Update Config: " + response);


            response = configStub.getActiveConfig(GoService.ConfigName.newBuilder().setName(config.getService()).build());
            System.out.println("Config: " + response.getGreeting());


            config = createConfig();
            response = configStub.addConfig(config);
            System.out.println("Add new Config: " + response.getGreeting());


            GoService.AllConfigs allConfigs = configStub.getAllConfigs(null);
            for (GoService.Config config1 : allConfigs.getConfigsList()){
                System.out.println(config1);
            }


            response = configStub.deleteConfig(GoService.ConfigNameAndVersion.newBuilder().setName("managed-k8s").setVersion(0).build());
            System.out.println("Delete: " + response.getGreeting());


            config = createConfig();
            response = configStub.addConfig(config);
            System.out.println("Add new Config: " + response.getGreeting());config = createConfig();

            response = configStub.addConfig(config);
            System.out.println("Add new Config: " + response.getGreeting());config = createConfig();

            response = configStub.addConfig(config);
            System.out.println("Add new Config: " + response.getGreeting());


            response = serviceStub.getActiveConfig(GoService.ServiceName.newBuilder().setName(service.getName()).build());
            System.out.println("Service Name: " + response.getGreeting());


            allConfigs = serviceStub.getConfigsService(GoService.ServiceName.newBuilder().setName(service.getName()).build());
            for (GoService.Config config1 : allConfigs.getConfigsList()){
                System.out.println(config1);
            }
            System.out.println("END");
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}