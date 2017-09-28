package com.cloud.feign.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("eureka-client")//表示访问eureka-client服务
public interface SchedualHiService {

	@RequestMapping(value = "/hi")//表示访问eureka-client服务的"/hi"接口
	String sayHi(@RequestParam(value = "name") String name);
	
}
