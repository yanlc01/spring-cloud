package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {
	
	public static void main(String[] args) {
//		SpringApplication.run(EurekaServerApplication.class, args);
		SpringApplication app = new SpringApplicationBuilder(EurekaServerApplication.class).build();

		app.run(args);
	}
	
	
}
