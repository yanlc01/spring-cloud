package com.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 分布式配置服务中心-服务端
 * 主要用于加载github或者本地的配置文件
 * @author yanlc
 *
 */
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class EurekaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaConfigServerApplication.class, args);
	}
	
}
