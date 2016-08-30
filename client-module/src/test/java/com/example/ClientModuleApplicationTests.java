package com.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(properties = {"my.client.url=http://localhost:38080"})
@SpringApplicationConfiguration(classes = ClientModuleApplicationTests.ExampleApp.class)
public class ClientModuleApplicationTests {

	@SpringBootApplication
	@Import({ClientModuleConfig.class})
	static class ExampleApp{}

	@BeforeClass
	public static void setUpWebModule() throws Exception {
		SpringApplication.run(WebModuleApplication.class, "--server.port=38080");
	}

	@Autowired
	ClientForApi clientForApi;

	@Test
	public void contextLoads() {
		assertNotNull(clientForApi);
		assertThat(clientForApi.hello(), is("Hello World!"));
	}

}
