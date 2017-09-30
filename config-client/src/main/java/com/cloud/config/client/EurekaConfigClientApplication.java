package com.cloud.config.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 分布式配置服务中心-客户端
 * 主要从配置服务中心-服务端读取配置属性
 * @author yanlc
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaConfigClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaConfigClientApplication.class, args);
	}
	
}
