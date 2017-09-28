package com.cloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 服务消费者
 * Feign是一个声明式的伪Http客户端
 * 默认集成了Ribbon
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class})
public class EurekaFeignApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignApplication.class, args);
//		SpringApplication app = new SpringApplicationBuilder(EurekaServerApplication.class).build();
//
//		app.run(args);
	}
	
}
