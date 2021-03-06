package com.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 路由网关
 * @author yanlc
 * zull是提供负载均衡-反向代理-权限认证功能的API Gateway
 */
@EnableEurekaClient
@EnableZuulProxy//开启zuul的功能
@SpringBootApplication
public class EurekaZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaZuulApplication.class, args);
	}
	
	
	
}
