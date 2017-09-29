package com.cloud.feign.service.hystrix;

import org.springframework.stereotype.Component;

import com.cloud.feign.service.SchedualHiService;

/**
 * 断路器类
 * @author yanlc
 *
 */
@Component
public class SchedualHiServiceHystrix implements SchedualHiService {

	@Override
	public String sayHi(String name) {
		return String.format("hi %s, error has happened", name);
	}

}
