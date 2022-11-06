package com.example.GoCloudCamp;

import com.example.GoCloudCamp.models.Config;
import com.example.GoCloudCamp.models.Service;
import com.example.GoCloudCamp.protoController.ConfigControl;
import com.example.GoCloudCamp.protoController.ServiceControl;
import com.example.grpc.ConfigServiceGrpc;
import com.example.grpc.GoService;
import com.example.grpc.ServiceServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class GoCloudCampApplicationTests {

	private static GoService.Service defServ;
	private static GoService.Service emptyServ;
	private static GoService.Config defConfig;
	private static GoService.Config emptyConfig;
	private static GoService.Config emptyDataConfig;
	private static GoService.Config emptyServiceConfig;
	private static ConfigControl configControl;
	private static ServiceControl serviceControl;
	private static ServiceServiceGrpc.ServiceServiceBlockingStub serviceStub;
	private static ConfigServiceGrpc.ConfigServiceBlockingStub configStub;

	@BeforeAll
	static void before(){
		ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
				.enableRetry().maxRetryAttempts(10).usePlaintext().build();
		serviceStub = ServiceServiceGrpc.newBlockingStub(channel);
		configStub = ConfigServiceGrpc.newBlockingStub(channel);
		defServ = GoService.Service.newBuilder().setName("managed-k8s").build();
		emptyServ = GoService.Service.newBuilder().build();
		List<GoService.Data> data = new ArrayList<>();
		data.add(GoService.Data.newBuilder().setKey("key1").setValue("value1").build());
		data.add(GoService.Data.newBuilder().setKey("key2").setValue("value2").build());
		defConfig = GoService.Config.newBuilder().setService("managed-k8s").addAllData(data).build();
		emptyConfig = GoService.Config.newBuilder().build();
		emptyDataConfig = GoService.Config.newBuilder().addAllData(data).build();
		emptyServiceConfig = GoService.Config.newBuilder().setService("managed-k8s").build();
		System.out.println(defConfig.getService());
	}

	@Test
	public void addServiceTest() {
		GoService.Response response = serviceStub.addService(defServ);
		Assertions.assertEquals("OK", response.getGreeting());
	}

	@Test
	public void addEmptyServiceTest(){
		Assertions.assertThrows(StatusRuntimeException.class, () -> serviceStub.addService(emptyServ));
		Assertions.assertThrows(StatusRuntimeException.class, () -> serviceStub.addService(defServ));
	}

	@Test
	public void getServiceTest(){
		GoService.Response response = serviceStub.addService(GoService.Service.newBuilder().setName("managed-k9s").build());
		Assertions.assertEquals("OK", response.getGreeting());
		response = serviceStub.getService(GoService.ServiceName.newBuilder().setName("managed-k9s").build());
		Assertions.assertEquals("managed-k9s", response.getGreeting());
	}

	@Test
	public void failGetServiceTest(){
		Assertions.assertThrows(StatusRuntimeException.class, () -> serviceStub.getService(GoService.ServiceName.newBuilder().build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> serviceStub.getService(GoService.ServiceName.newBuilder().setName("fail").build()));
	}

	@Test
	public void getConfigsService(){
		GoService.Service service = GoService.Service.newBuilder().setName("getConfigsService").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		List<GoService.Config> configs = new ArrayList<>();
		List<GoService.Data> data = new ArrayList<>();
		data.add(GoService.Data.newBuilder().setKey("key1").setValue("value1").build());
		data.add(GoService.Data.newBuilder().setKey("key2").setValue("value2").build());
		GoService.Config config = GoService.Config.newBuilder().setService("getConfigsService").addAllData(data).build();
		configs.add(config);
		response = configStub.addConfig(config);
		Assertions.assertEquals("OK", response.getGreeting());
		config = GoService.Config.newBuilder().setService("getConfigsService").addAllData(data).build();
		configs.add(config);
		response = configStub.addConfig(config);
		Assertions.assertEquals("OK", response.getGreeting());
		GoService.AllConfigs allConfigs1 = GoService.AllConfigs.newBuilder().addAllConfigs(configs).build();
		GoService.AllConfigs allConfigs = serviceStub
				.getConfigsService(GoService.ServiceName.newBuilder().setName("getConfigsService").build());
		Assertions.assertEquals(allConfigs1, allConfigs);
	}

	@Test
	public void failGetConfigsService(){
		Assertions.assertThrows(StatusRuntimeException.class, () -> serviceStub.getConfigsService(GoService.ServiceName.newBuilder().build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> serviceStub.getConfigsService(GoService.ServiceName.newBuilder().setName("fail").build()));

	}

	@Test
	public void getActiveConfigTest(){
		GoService.Service service = GoService.Service.newBuilder().setName("getActiveConfigTest").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		List<GoService.Data> data = new ArrayList<>();
		data.add(GoService.Data.newBuilder().setKey("key1").setValue("value1").build());
		data.add(GoService.Data.newBuilder().setKey("key2").setValue("value2").build());
		GoService.Config config = GoService.Config.newBuilder().setService("getActiveConfigTest").addAllData(data).build();
		GoService.Config config1 = GoService.Config.newBuilder().setService("getActiveConfigTest").addAllData(data).build();
		response = configStub.addConfig(config);
		Assertions.assertEquals("OK", response.getGreeting());
		response = configStub.addConfig(config1);
		Assertions.assertEquals("OK", response.getGreeting());
		response = serviceStub.getActiveConfig(GoService.ServiceName.newBuilder().setName("getActiveConfigTest").build());
		Assertions.assertEquals("{key1=value1, key2=value2}", response.getGreeting());
	}

	@Test
	public void failGetActiveConfigTest(){
		GoService.Service service = GoService.Service.newBuilder().setName("failActiveConfigTest").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		Assertions.assertThrows(StatusRuntimeException.class, () -> serviceStub.getActiveConfig(GoService.ServiceName.newBuilder().build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> serviceStub.getActiveConfig(GoService.ServiceName.newBuilder().setName("fail").build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> serviceStub.getActiveConfig(GoService.ServiceName.newBuilder().setName("failActiveConfigTest").build()));
	}

	@Test
	public void deleteServiceTest(){
		GoService.Service service = GoService.Service.newBuilder().setName("deleteServiceTest").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		response = serviceStub.deleteService(GoService.ServiceName.newBuilder().setName("deleteServiceTest").build());
		Assertions.assertEquals("OK", response.getGreeting());
	}

	@Test
	public void failDeleteServiceTest(){
		GoService.Service service = GoService.Service.newBuilder().setName("failDeleteServiceTest").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		Assertions.assertThrows(StatusRuntimeException.class, () -> serviceStub.deleteService(GoService.ServiceName.newBuilder().build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> serviceStub.deleteService(GoService.ServiceName.newBuilder().setName("fail").build()));
	}

	@Test
	public void addConfigTest() {
		GoService.Service service = GoService.Service.newBuilder().setName("addConfigTest").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		response = configStub.addConfig(defConfig);
		Assertions.assertEquals("OK", response.getGreeting());
		response = configStub.addConfig(defConfig);
		Assertions.assertEquals("OK", response.getGreeting());
	}

	@Test
	public void failAddConfigTest(){
		GoService.Service service = GoService.Service.newBuilder().setName("failAddConfigTest").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		List<GoService.Data> data = new ArrayList<>();
		data.add(GoService.Data.newBuilder().setKey("key1").setValue("value1").build());
		data.add(GoService.Data.newBuilder().setKey("key2").setValue("value2").build());
		GoService.Config config = GoService.Config.newBuilder().setService("failAddConfigTest").addAllData(data).build();
		GoService.Config config1 = GoService.Config.newBuilder().setService("failAddConfigTest").addAllData(data).build();
		response = configStub.addConfig(config);
		Assertions.assertEquals("OK", response.getGreeting());
		response = configStub.addConfig(config1);
		Assertions.assertEquals("OK", response.getGreeting());
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.addConfig(GoService.Config.newBuilder().build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.addConfig(GoService.Config.newBuilder().addAllData(data).build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.addConfig(GoService.Config.newBuilder().setService("fail").build()));
	}

	@Test
	public void getConfigTest(){
		GoService.Response response = configStub.addConfig(defConfig);
		Assertions.assertEquals("OK", response.getGreeting());
		response = configStub.getActiveConfig(GoService.ConfigName.newBuilder().setName(defConfig.getService()).build());
		Assertions.assertEquals("{key1=value1, key2=value2}", response.getGreeting());
	}

	@Test
	public void failGetConfigTest(){
		GoService.Service service = GoService.Service.newBuilder().setName("failGetConfigTest").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.getActiveConfig(GoService.ConfigName.newBuilder().build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.getActiveConfig(GoService.ConfigName.newBuilder().setName("failGetConfigTest").build()));
	}

	@Test
	public void getAllConfigs(){
		Assertions.assertEquals(configStub.getAllConfigs(null).getConfigsList().size(), 18);
	}

	@Test
	public void getConfigVersion(){
		GoService.Service service = GoService.Service.newBuilder().setName("getConfigVersion").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		List<GoService.Data> data = new ArrayList<>();
		data.add(GoService.Data.newBuilder().setKey("key1").setValue("value1").build());
		data.add(GoService.Data.newBuilder().setKey("key2").setValue("value2").build());
		GoService.Config config = GoService.Config.newBuilder().setService("getConfigVersion").addAllData(data).build();
		GoService.Config config1 = GoService.Config.newBuilder().setService("getConfigVersion").addAllData(data).build();
		response = configStub.addConfig(config);
		Assertions.assertEquals("OK", response.getGreeting());
		response = configStub.addConfig(config1);
		Assertions.assertEquals("OK", response.getGreeting());
		Assertions.assertEquals("{key1=value1, key2=value2}", configStub.getConfigVersion(GoService.ConfigNameAndVersion
				.newBuilder().setName("getConfigVersion").setVersion(1).build()).getGreeting());
	}

	@Test
	public void failGetConfigVersion(){
		GoService.Service service = GoService.Service.newBuilder().setName("failGetConfigVersion").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		List<GoService.Data> data = new ArrayList<>();
		data.add(GoService.Data.newBuilder().setKey("key1").setValue("value1").build());
		data.add(GoService.Data.newBuilder().setKey("key2").setValue("value2").build());
		GoService.Config config = GoService.Config.newBuilder().setService("failGetConfigVersion").addAllData(data).build();
		GoService.Config config1 = GoService.Config.newBuilder().setService("failGetConfigVersion").addAllData(data).build();
		response = configStub.addConfig(config);
		Assertions.assertEquals("OK", response.getGreeting());
		response = configStub.addConfig(config1);
		Assertions.assertEquals("OK", response.getGreeting());
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.getConfigVersion(GoService.ConfigNameAndVersion.newBuilder().build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.getConfigVersion(GoService.ConfigNameAndVersion.newBuilder().setName("failGetConfigVersion").setVersion(3).build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.getConfigVersion(GoService.ConfigNameAndVersion.newBuilder().setName("qwe").build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.getConfigVersion(GoService.ConfigNameAndVersion.newBuilder().setVersion(13).build()));
	}

	@Test
	public void updateConfigTest(){
		GoService.Service service = GoService.Service.newBuilder().setName("updateConfigTest").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		List<GoService.Data> data = new ArrayList<>();
		data.add(GoService.Data.newBuilder().setKey("key1").setValue("value1").build());
		data.add(GoService.Data.newBuilder().setKey("key2").setValue("value2").build());
		GoService.Config config = GoService.Config.newBuilder().setService("updateConfigTest").addAllData(data).build();
		response = configStub.addConfig(config);
		Assertions.assertEquals("OK", response.getGreeting());
		List<GoService.Data> data1 = new ArrayList<>();
		data1.add(GoService.Data.newBuilder().setKey("key5").setValue("value5").build());
		data1.add(GoService.Data.newBuilder().setKey("key6").setValue("value6").build());
		GoService.Config config1 = GoService.Config.newBuilder().setService("updateConfigTest").addAllData(data1).build();
		response = configStub.updateConfig(config1);
		Assertions.assertEquals("OK", response.getGreeting());
	}

	@Test
	public void failUpdateConfigTest(){
		GoService.Service service = GoService.Service.newBuilder().setName("failUpdateConfigTest").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		List<GoService.Data> data = new ArrayList<>();
		data.add(GoService.Data.newBuilder().setKey("key1").setValue("value1").build());
		data.add(GoService.Data.newBuilder().setKey("key2").setValue("value2").build());
		GoService.Config config = GoService.Config.newBuilder().setService("failUpdateConfigTest").addAllData(data).build();
		response = configStub.addConfig(config);
		Assertions.assertEquals("OK", response.getGreeting());
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.updateConfig(GoService.Config.newBuilder().build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.updateConfig(GoService.Config.newBuilder().addAllData(data).build()));
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.updateConfig(GoService.Config.newBuilder().setService("fail").build()));
	}

	@Test
	public void deleteConfigTest(){
		GoService.Service service = GoService.Service.newBuilder().setName("deleteConfigTest").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		List<GoService.Data> data = new ArrayList<>();
		data.add(GoService.Data.newBuilder().setKey("key1").setValue("value1").build());
		data.add(GoService.Data.newBuilder().setKey("key2").setValue("value2").build());
		GoService.Config config = GoService.Config.newBuilder().setService("deleteConfigTest").addAllData(data).build();
		GoService.Config config1 = GoService.Config.newBuilder().setService("deleteConfigTest").addAllData(data).build();
		response = configStub.addConfig(config);
		Assertions.assertEquals("OK", response.getGreeting());
		response = configStub.addConfig(config1);
		Assertions.assertEquals("OK", response.getGreeting());
		GoService.ConfigNameAndVersion configNameAndVersion =
				GoService.ConfigNameAndVersion.newBuilder().setName("deleteConfigTest").setVersion(0).build();
		response = configStub.deleteConfig(configNameAndVersion);
		Assertions.assertEquals("OK", response.getGreeting());
	}

	@Test
	public void failConfigTests(){
		GoService.Service service = GoService.Service.newBuilder().setName("failConfigTests").build();
		GoService.Response response = serviceStub.addService(service);
		Assertions.assertEquals("OK", response.getGreeting());
		List<GoService.Data> data = new ArrayList<>();
		data.add(GoService.Data.newBuilder().setKey("key1").setValue("value1").build());
		data.add(GoService.Data.newBuilder().setKey("key2").setValue("value2").build());
		GoService.Config config = GoService.Config.newBuilder().setService("failConfigTests").addAllData(data).build();
		GoService.Config config1 = GoService.Config.newBuilder().setService("failConfigTests").addAllData(data).build();
		response = configStub.addConfig(config);
		Assertions.assertEquals("OK", response.getGreeting());
		response = configStub.addConfig(config1);
		Assertions.assertEquals("OK", response.getGreeting());
		GoService.ConfigNameAndVersion configNameAndVersion =
				GoService.ConfigNameAndVersion.newBuilder().setName("failConfigTests").setVersion(1).build();
		GoService.ConfigNameAndVersion configNameAndVersion1 =
				GoService.ConfigNameAndVersion.newBuilder().setName("fail").build();
		GoService.ConfigNameAndVersion configNameAndVersion2 =
				GoService.ConfigNameAndVersion.newBuilder().build();
		GoService.ConfigNameAndVersion configNameAndVersion3 =
				GoService.ConfigNameAndVersion.newBuilder().setName("failConfigTests").build();
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.deleteConfig(configNameAndVersion));
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.deleteConfig(configNameAndVersion1));
		Assertions.assertThrows(StatusRuntimeException.class, () -> configStub.deleteConfig(configNameAndVersion2));
	}

	@Test
	public void util(){
		Config config = new Config();
		Assertions.assertEquals("Config{id=0, service='null', data=null, time=0, active=false, serviceId=null}", config.toString());

		Service service = new Service();
		service.setId(3);
		int i = service.getId();
		service.setConfigs(new ArrayList<>());
		Assertions.assertEquals("Service{id=3, name='null', configs=[]}", service.toString());
	}
}
