package com.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
//		app.run(args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public AlwaysSampler defaultSampler() {
		return new AlwaysSampler();
	}
	
}
