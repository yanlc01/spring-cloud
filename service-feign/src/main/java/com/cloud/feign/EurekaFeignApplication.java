package com.cloud.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 服务消费者
 * Feign是一个声明式的伪Http客户端，默认集成了Ribbon
 * 1、Feign负载均衡
 * 2、Feign中使用断路器（Feign自带断路器，但是需要在配置文件开启）
 * 		Hystrix Dashboard (断路器：Hystrix仪表盘)：http://localhost:8765/hystrix
 */
@EnableDiscoveryClient//用于负载均衡
@EnableFeignClients//用于负载均衡
@EnableHystrixDashboard//用于断路器仪表盘
@EnableCircuitBreaker
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
