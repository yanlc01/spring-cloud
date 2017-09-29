package com.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务提供者
 * @author yanlc
 *
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
//		SpringApplication app = new SpringApplicationBuilder(EurekaServerApplication.class).build();
//
//		app.run(args);
	}
	
	
}
