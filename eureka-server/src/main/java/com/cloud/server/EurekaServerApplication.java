package com.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注册中心
 * @author yanlc
 *
 */
@EnableEurekaServer
@SpringBootApplication
//禁止自动加载数据库配置
//@SpringBootApplication(exclude = {
//		DataSourceAutoConfiguration.class,
//		DataSourceTransactionManagerAutoConfiguration.class,
//		HibernateJpaAutoConfiguration.class})
public class EurekaServerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
//		SpringApplication app = new SpringApplicationBuilder(EurekaServerApplication.class).build();
//
//		app.run(args);
	}
	
	
}
