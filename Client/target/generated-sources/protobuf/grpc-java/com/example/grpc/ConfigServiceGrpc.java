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
public final class ConfigServiceGrpc {

  private ConfigServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.ConfigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GoService.Config,
      com.example.grpc.GoService.Response> getAddConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addConfig",
      requestType = com.example.grpc.GoService.Config.class,
      responseType = com.example.grpc.GoService.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GoService.Config,
      com.example.grpc.GoService.Response> getAddConfigMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GoService.Config, com.example.grpc.GoService.Response> getAddConfigMethod;
    if ((getAddConfigMethod = ConfigServiceGrpc.getAddConfigMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getAddConfigMethod = ConfigServiceGrpc.getAddConfigMethod) == null) {
          ConfigServiceGrpc.getAddConfigMethod = getAddConfigMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GoService.Config, com.example.grpc.GoService.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Config.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("addConfig"))
              .build();
        }
      }
    }
    return getAddConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GoService.ConfigName,
      com.example.grpc.GoService.Response> getGetActiveConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getActiveConfig",
      requestType = com.example.grpc.GoService.ConfigName.class,
      responseType = com.example.grpc.GoService.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GoService.ConfigName,
      com.example.grpc.GoService.Response> getGetActiveConfigMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GoService.ConfigName, com.example.grpc.GoService.Response> getGetActiveConfigMethod;
    if ((getGetActiveConfigMethod = ConfigServiceGrpc.getGetActiveConfigMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getGetActiveConfigMethod = ConfigServiceGrpc.getGetActiveConfigMethod) == null) {
          ConfigServiceGrpc.getGetActiveConfigMethod = getGetActiveConfigMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GoService.ConfigName, com.example.grpc.GoService.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getActiveConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.ConfigName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("getActiveConfig"))
              .build();
        }
      }
    }
    return getGetActiveConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.grpc.GoService.AllConfigs> getGetAllConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllConfigs",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.example.grpc.GoService.AllConfigs.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.grpc.GoService.AllConfigs> getGetAllConfigsMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.example.grpc.GoService.AllConfigs> getGetAllConfigsMethod;
    if ((getGetAllConfigsMethod = ConfigServiceGrpc.getGetAllConfigsMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getGetAllConfigsMethod = ConfigServiceGrpc.getGetAllConfigsMethod) == null) {
          ConfigServiceGrpc.getGetAllConfigsMethod = getGetAllConfigsMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.grpc.GoService.AllConfigs>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllConfigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.AllConfigs.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("getAllConfigs"))
              .build();
        }
      }
    }
    return getGetAllConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GoService.ConfigNameAndVersion,
      com.example.grpc.GoService.Response> getGetConfigVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getConfigVersion",
      requestType = com.example.grpc.GoService.ConfigNameAndVersion.class,
      responseType = com.example.grpc.GoService.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GoService.ConfigNameAndVersion,
      com.example.grpc.GoService.Response> getGetConfigVersionMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GoService.ConfigNameAndVersion, com.example.grpc.GoService.Response> getGetConfigVersionMethod;
    if ((getGetConfigVersionMethod = ConfigServiceGrpc.getGetConfigVersionMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getGetConfigVersionMethod = ConfigServiceGrpc.getGetConfigVersionMethod) == null) {
          ConfigServiceGrpc.getGetConfigVersionMethod = getGetConfigVersionMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GoService.ConfigNameAndVersion, com.example.grpc.GoService.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getConfigVersion"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.ConfigNameAndVersion.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("getConfigVersion"))
              .build();
        }
      }
    }
    return getGetConfigVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GoService.Config,
      com.example.grpc.GoService.Response> getUpdateConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateConfig",
      requestType = com.example.grpc.GoService.Config.class,
      responseType = com.example.grpc.GoService.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GoService.Config,
      com.example.grpc.GoService.Response> getUpdateConfigMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GoService.Config, com.example.grpc.GoService.Response> getUpdateConfigMethod;
    if ((getUpdateConfigMethod = ConfigServiceGrpc.getUpdateConfigMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getUpdateConfigMethod = ConfigServiceGrpc.getUpdateConfigMethod) == null) {
          ConfigServiceGrpc.getUpdateConfigMethod = getUpdateConfigMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GoService.Config, com.example.grpc.GoService.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Config.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("updateConfig"))
              .build();
        }
      }
    }
    return getUpdateConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GoService.ConfigNameAndVersion,
      com.example.grpc.GoService.Response> getDeleteConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteConfig",
      requestType = com.example.grpc.GoService.ConfigNameAndVersion.class,
      responseType = com.example.grpc.GoService.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GoService.ConfigNameAndVersion,
      com.example.grpc.GoService.Response> getDeleteConfigMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GoService.ConfigNameAndVersion, com.example.grpc.GoService.Response> getDeleteConfigMethod;
    if ((getDeleteConfigMethod = ConfigServiceGrpc.getDeleteConfigMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getDeleteConfigMethod = ConfigServiceGrpc.getDeleteConfigMethod) == null) {
          ConfigServiceGrpc.getDeleteConfigMethod = getDeleteConfigMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GoService.ConfigNameAndVersion, com.example.grpc.GoService.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.ConfigNameAndVersion.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GoService.Response.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("deleteConfig"))
              .build();
        }
      }
    }
    return getDeleteConfigMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConfigServiceStub newStub(io.grpc.Channel channel) {
    return new ConfigServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ConfigServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConfigServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ConfigServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ConfigServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addConfig(com.example.grpc.GoService.Config request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getAddConfigMethod(), responseObserver);
    }

    /**
     */
    public void getActiveConfig(com.example.grpc.GoService.ConfigName request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetActiveConfigMethod(), responseObserver);
    }

    /**
     */
    public void getAllConfigs(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.AllConfigs> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllConfigsMethod(), responseObserver);
    }

    /**
     */
    public void getConfigVersion(com.example.grpc.GoService.ConfigNameAndVersion request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getGetConfigVersionMethod(), responseObserver);
    }

    /**
     */
    public void updateConfig(com.example.grpc.GoService.Config request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateConfigMethod(), responseObserver);
    }

    /**
     */
    public void deleteConfig(com.example.grpc.GoService.ConfigNameAndVersion request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteConfigMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GoService.Config,
                com.example.grpc.GoService.Response>(
                  this, METHODID_ADD_CONFIG)))
          .addMethod(
            getGetActiveConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GoService.ConfigName,
                com.example.grpc.GoService.Response>(
                  this, METHODID_GET_ACTIVE_CONFIG)))
          .addMethod(
            getGetAllConfigsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.example.grpc.GoService.AllConfigs>(
                  this, METHODID_GET_ALL_CONFIGS)))
          .addMethod(
            getGetConfigVersionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GoService.ConfigNameAndVersion,
                com.example.grpc.GoService.Response>(
                  this, METHODID_GET_CONFIG_VERSION)))
          .addMethod(
            getUpdateConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GoService.Config,
                com.example.grpc.GoService.Response>(
                  this, METHODID_UPDATE_CONFIG)))
          .addMethod(
            getDeleteConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GoService.ConfigNameAndVersion,
                com.example.grpc.GoService.Response>(
                  this, METHODID_DELETE_CONFIG)))
          .build();
    }
  }

  /**
   */
  public static final class ConfigServiceStub extends io.grpc.stub.AbstractStub<ConfigServiceStub> {
    private ConfigServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceStub(channel, callOptions);
    }

    /**
     */
    public void addConfig(com.example.grpc.GoService.Config request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getActiveConfig(com.example.grpc.GoService.ConfigName request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetActiveConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllConfigs(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.AllConfigs> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllConfigsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getConfigVersion(com.example.grpc.GoService.ConfigNameAndVersion request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetConfigVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateConfig(com.example.grpc.GoService.Config request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteConfig(com.example.grpc.GoService.ConfigNameAndVersion request,
        io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteConfigMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ConfigServiceBlockingStub extends io.grpc.stub.AbstractStub<ConfigServiceBlockingStub> {
    private ConfigServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.GoService.Response addConfig(com.example.grpc.GoService.Config request) {
      return blockingUnaryCall(
          getChannel(), getAddConfigMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.GoService.Response getActiveConfig(com.example.grpc.GoService.ConfigName request) {
      return blockingUnaryCall(
          getChannel(), getGetActiveConfigMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.GoService.AllConfigs getAllConfigs(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllConfigsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.GoService.Response getConfigVersion(com.example.grpc.GoService.ConfigNameAndVersion request) {
      return blockingUnaryCall(
          getChannel(), getGetConfigVersionMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.GoService.Response updateConfig(com.example.grpc.GoService.Config request) {
      return blockingUnaryCall(
          getChannel(), getUpdateConfigMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.GoService.Response deleteConfig(com.example.grpc.GoService.ConfigNameAndVersion request) {
      return blockingUnaryCall(
          getChannel(), getDeleteConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ConfigServiceFutureStub extends io.grpc.stub.AbstractStub<ConfigServiceFutureStub> {
    private ConfigServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.Response> addConfig(
        com.example.grpc.GoService.Config request) {
      return futureUnaryCall(
          getChannel().newCall(getAddConfigMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.Response> getActiveConfig(
        com.example.grpc.GoService.ConfigName request) {
      return futureUnaryCall(
          getChannel().newCall(getGetActiveConfigMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.AllConfigs> getAllConfigs(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllConfigsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.Response> getConfigVersion(
        com.example.grpc.GoService.ConfigNameAndVersion request) {
      return futureUnaryCall(
          getChannel().newCall(getGetConfigVersionMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.Response> updateConfig(
        com.example.grpc.GoService.Config request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateConfigMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GoService.Response> deleteConfig(
        com.example.grpc.GoService.ConfigNameAndVersion request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_CONFIG = 0;
  private static final int METHODID_GET_ACTIVE_CONFIG = 1;
  private static final int METHODID_GET_ALL_CONFIGS = 2;
  private static final int METHODID_GET_CONFIG_VERSION = 3;
  private static final int METHODID_UPDATE_CONFIG = 4;
  private static final int METHODID_DELETE_CONFIG = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConfigServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConfigServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_CONFIG:
          serviceImpl.addConfig((com.example.grpc.GoService.Config) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response>) responseObserver);
          break;
        case METHODID_GET_ACTIVE_CONFIG:
          serviceImpl.getActiveConfig((com.example.grpc.GoService.ConfigName) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response>) responseObserver);
          break;
        case METHODID_GET_ALL_CONFIGS:
          serviceImpl.getAllConfigs((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GoService.AllConfigs>) responseObserver);
          break;
        case METHODID_GET_CONFIG_VERSION:
          serviceImpl.getConfigVersion((com.example.grpc.GoService.ConfigNameAndVersion) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response>) responseObserver);
          break;
        case METHODID_UPDATE_CONFIG:
          serviceImpl.updateConfig((com.example.grpc.GoService.Config) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GoService.Response>) responseObserver);
          break;
        case METHODID_DELETE_CONFIG:
          serviceImpl.deleteConfig((com.example.grpc.GoService.ConfigNameAndVersion) request,
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

  private static abstract class ConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.GoService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConfigService");
    }
  }

  private static final class ConfigServiceFileDescriptorSupplier
      extends ConfigServiceBaseDescriptorSupplier {
    ConfigServiceFileDescriptorSupplier() {}
  }

  private static final class ConfigServiceMethodDescriptorSupplier
      extends ConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConfigServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ConfigServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConfigServiceFileDescriptorSupplier())
              .addMethod(getAddConfigMethod())
              .addMethod(getGetActiveConfigMethod())
              .addMethod(getGetAllConfigsMethod())
              .addMethod(getGetConfigVersionMethod())
              .addMethod(getUpdateConfigMethod())
              .addMethod(getDeleteConfigMethod())
              .build();
        }
      }
    }
    return result;
  }
}
