package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: GoService.proto")
public final class ServiceServiceGrpc {

  private ServiceServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.ServiceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GoService.Service,
      com.example.grpc.GoService.Response> getAddServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addService",
      requestType = com.example.grpc.GoService.Service.class,
      responseType = com.example.grpc.GoService.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GoService.Service,
      com.example.grpc.GoService.Response> getAddServiceMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GoService.Service, com.example.grpc.GoService.Response> getAddServiceMethod;
    if ((getAddServiceMethod = ServiceServiceGrpc.getAddServiceMethod) == null) {
      synchronized (ServiceServiceGrpc.class) {
        if ((getAddServiceMethod = ServiceServiceGrpc.getAddServiceMethod) == null) {
          ServiceServiceGrpc.getAddServiceMethod = getAddServiceMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GoService.Service, com.example.grpc.GoService.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Service.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceServiceMethodDescriptorSupplier("addService"))
              .build();
        }
      }
    }
    return getAddServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName,
      com.example.grpc.GoService.Response> getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getService",
      requestType = com.example.grpc.GoService.ServiceName.class,
      responseType = com.example.grpc.GoService.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName,
      com.example.grpc.GoService.Response> getGetServiceMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName, com.example.grpc.GoService.Response> getGetServiceMethod;
    if ((getGetServiceMethod = ServiceServiceGrpc.getGetServiceMethod) == null) {
      synchronized (ServiceServiceGrpc.class) {
        if ((getGetServiceMethod = ServiceServiceGrpc.getGetServiceMethod) == null) {
          ServiceServiceGrpc.getGetServiceMethod = getGetServiceMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GoService.ServiceName, com.example.grpc.GoService.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.ServiceName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceServiceMethodDescriptorSupplier("getService"))
              .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GoService.Service,
      com.example.grpc.GoService.Response> getUpdateServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateService",
      requestType = com.example.grpc.GoService.Service.class,
      responseType = com.example.grpc.GoService.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GoService.Service,
      com.example.grpc.GoService.Response> getUpdateServiceMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GoService.Service, com.example.grpc.GoService.Response> getUpdateServiceMethod;
    if ((getUpdateServiceMethod = ServiceServiceGrpc.getUpdateServiceMethod) == null) {
      synchronized (ServiceServiceGrpc.class) {
        if ((getUpdateServiceMethod = ServiceServiceGrpc.getUpdateServiceMethod) == null) {
          ServiceServiceGrpc.getUpdateServiceMethod = getUpdateServiceMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GoService.Service, com.example.grpc.GoService.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Service.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceServiceMethodDescriptorSupplier("updateService"))
              .build();
        }
      }
    }
    return getUpdateServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName,
      com.example.grpc.GoService.Response> getDeleteServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteService",
      requestType = com.example.grpc.GoService.ServiceName.class,
      responseType = com.example.grpc.GoService.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName,
      com.example.grpc.GoService.Response> getDeleteServiceMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName, com.example.grpc.GoService.Response> getDeleteServiceMethod;
    if ((getDeleteServiceMethod = ServiceServiceGrpc.getDeleteServiceMethod) == null) {
      synchronized (ServiceServiceGrpc.class) {
        if ((getDeleteServiceMethod = ServiceServiceGrpc.getDeleteServiceMethod) == null) {
          ServiceServiceGrpc.getDeleteServiceMethod = getDeleteServiceMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GoService.ServiceName, com.example.grpc.GoService.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.ServiceName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceServiceMethodDescriptorSupplier("deleteService"))
              .build();
        }
      }
    }
    return getDeleteServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName,
      com.example.grpc.GoService.AllConfigs> getGetConfigsServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getConfigsService",
      requestType = com.example.grpc.GoService.ServiceName.class,
      responseType = com.example.grpc.GoService.AllConfigs.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName,
      com.example.grpc.GoService.AllConfigs> getGetConfigsServiceMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName, com.example.grpc.GoService.AllConfigs> getGetConfigsServiceMethod;
    if ((getGetConfigsServiceMethod = ServiceServiceGrpc.getGetConfigsServiceMethod) == null) {
      synchronized (ServiceServiceGrpc.class) {
        if ((getGetConfigsServiceMethod = ServiceServiceGrpc.getGetConfigsServiceMethod) == null) {
          ServiceServiceGrpc.getGetConfigsServiceMethod = getGetConfigsServiceMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GoService.ServiceName, com.example.grpc.GoService.AllConfigs>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getConfigsService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.ServiceName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.AllConfigs.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceServiceMethodDescriptorSupplier("getConfigsService"))
              .build();
        }
      }
    }
    return getGetConfigsServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName,
      com.example.grpc.GoService.Response> getGetActiveConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getActiveConfig",
      requestType = com.example.grpc.GoService.ServiceName.class,
      responseType = com.example.grpc.GoService.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName,
      com.example.grpc.GoService.Response> getGetActiveConfigMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GoService.ServiceName, com.example.grpc.GoService.Response> getGetActiveConfigMethod;
    if ((getGetActiveConfigMethod = ServiceServiceGrpc.getGetActiveConfigMethod) == null) {
      synchronized (ServiceServiceGrpc.class) {
        if ((getGetActiveConfigMethod = ServiceServiceGrpc.getGetActiveConfigMethod) == null) {
          ServiceServiceGrpc.getGetActiveConfigMethod = getGetActiveConfigMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GoService.ServiceName, com.example.grpc.GoService.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getActiveConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.ServiceName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceServiceMethodDescriptorSupplier("getActiveConfig"))
              .build();
        }
      }
    }
    return getGetActiveConfigMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceServiceStub newStub(io.grpc.Channel channel) {
    return new ServiceServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ServiceServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ServiceServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ServiceServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addService(com.example.grpc.GoService.Service request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getAddServiceMethod(), responseObserver);
    }

    /**
     */
    public void getService(com.example.grpc.GoService.ServiceName request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     */
    public void updateService(com.example.grpc.GoService.Service request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateServiceMethod(), responseObserver);
    }

    /**
     */
    public void deleteService(com.example.grpc.GoService.ServiceName request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteServiceMethod(), responseObserver);
    }

    /**
     */
    public void getConfigsService(com.example.grpc.GoService.ServiceName request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.AllConfigs> responseObserver) {
      asyncUnimplementedUnaryCall(getGetConfigsServiceMethod(), responseObserver);
    }

    /**
     */
    public void getActiveConfig(com.example.grpc.GoService.ServiceName request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetActiveConfigMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GoService.Service,
                com.example.grpc.GoService.Response>(
                  this, METHODID_ADD_SERVICE)))
          .addMethod(
            getGetServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GoService.ServiceName,
                com.example.grpc.GoService.Response>(
                  this, METHODID_GET_SERVICE)))
          .addMethod(
            getUpdateServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GoService.Service,
                com.example.grpc.GoService.Response>(
                  this, METHODID_UPDATE_SERVICE)))
          .addMethod(
            getDeleteServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GoService.ServiceName,
                com.example.grpc.GoService.Response>(
                  this, METHODID_DELETE_SERVICE)))
          .addMethod(
            getGetConfigsServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GoService.ServiceName,
                com.example.grpc.GoService.AllConfigs>(
                  this, METHODID_GET_CONFIGS_SERVICE)))
          .addMethod(
            getGetActiveConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GoService.ServiceName,
                com.example.grpc.GoService.Response>(
                  this, METHODID_GET_ACTIVE_CONFIG)))
          .build();
    }
  }

  /**
   */
  public static final class ServiceServiceStub extends io.grpc.stub.AbstractStub<ServiceServiceStub> {
    private ServiceServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceServiceStub(channel, callOptions);
    }

    /**
     */
    public void addService(com.example.grpc.GoService.Service request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getService(com.example.grpc.GoService.ServiceName request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateService(com.example.grpc.GoService.Service request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteService(com.example.grpc.GoService.ServiceName request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getConfigsService(com.example.grpc.GoService.ServiceName request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.AllConfigs> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetConfigsServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getActiveConfig(com.example.grpc.GoService.ServiceName request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetActiveConfigMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServiceServiceBlockingStub extends io.grpc.stub.AbstractStub<ServiceServiceBlockingStub> {
    private ServiceServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.GoService.Response addService(com.example.grpc.GoService.Service request) {
      return blockingUnaryCall(
          getChannel(), getAddServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.GoService.Response getService(com.example.grpc.GoService.ServiceName request) {
      return blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.GoService.Response updateService(com.example.grpc.GoService.Service request) {
      return blockingUnaryCall(
          getChannel(), getUpdateServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.GoService.Response deleteService(com.example.grpc.GoService.ServiceName request) {
      return blockingUnaryCall(
          getChannel(), getDeleteServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.GoService.AllConfigs getConfigsService(com.example.grpc.GoService.ServiceName request) {
      return blockingUnaryCall(
          getChannel(), getGetConfigsServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.GoService.Response getActiveConfig(com.example.grpc.GoService.ServiceName request) {
      return blockingUnaryCall(
          getChannel(), getGetActiveConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServiceServiceFutureStub extends io.grpc.stub.AbstractStub<ServiceServiceFutureStub> {
    private ServiceServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.Response> addService(
        com.example.grpc.GoService.Service request) {
      return futureUnaryCall(
          getChannel().newCall(getAddServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.Response> getService(
        com.example.grpc.GoService.ServiceName request) {
      return futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.Response> updateService(
        com.example.grpc.GoService.Service request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.Response> deleteService(
        com.example.grpc.GoService.ServiceName request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.AllConfigs> getConfigsService(
        com.example.grpc.GoService.ServiceName request) {
      return futureUnaryCall(
          getChannel().newCall(getGetConfigsServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.Response> getActiveConfig(
        com.example.grpc.GoService.ServiceName request) {
      return futureUnaryCall(
          getChannel().newCall(getGetActiveConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_SERVICE = 0;
  private static final int METHODID_GET_SERVICE = 1;
  private static final int METHODID_UPDATE_SERVICE = 2;
  private static final int METHODID_DELETE_SERVICE = 3;
  private static final int METHODID_GET_CONFIGS_SERVICE = 4;
  private static final int METHODID_GET_ACTIVE_CONFIG = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_SERVICE:
          serviceImpl.addService((com.example.grpc.GoService.Service) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response>) responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService((com.example.grpc.GoService.ServiceName) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response>) responseObserver);
          break;
        case METHODID_UPDATE_SERVICE:
          serviceImpl.updateService((com.example.grpc.GoService.Service) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE:
          serviceImpl.deleteService((com.example.grpc.GoService.ServiceName) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response>) responseObserver);
          break;
        case METHODID_GET_CONFIGS_SERVICE:
          serviceImpl.getConfigsService((com.example.grpc.GoService.ServiceName) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GoService.AllConfigs>) responseObserver);
          break;
        case METHODID_GET_ACTIVE_CONFIG:
          serviceImpl.getActiveConfig((com.example.grpc.GoService.ServiceName) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ServiceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.GoService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceService");
    }
  }

  private static final class ServiceServiceFileDescriptorSupplier
      extends ServiceServiceBaseDescriptorSupplier {
    ServiceServiceFileDescriptorSupplier() {}
  }

  private static final class ServiceServiceMethodDescriptorSupplier
      extends ServiceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ServiceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceServiceFileDescriptorSupplier())
              .addMethod(getAddServiceMethod())
              .addMethod(getGetServiceMethod())
              .addMethod(getUpdateServiceMethod())
              .addMethod(getDeleteServiceMethod())
              .addMethod(getGetConfigsServiceMethod())
              .addMethod(getGetActiveConfigMethod())
              .build();
        }
      }
    }
    return result;
  }
}
