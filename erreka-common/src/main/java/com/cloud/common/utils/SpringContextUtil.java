package com.cloud.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring应用上下文环境
 * @author yanlc
 *
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/**
	 * 实现ApplicationContextAware接口的回调方法，设置上下文环境
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringContextUtil.applicationContext == null) {
			SpringContextUtil.applicationContext = applicationContext;
		}
	}
	
	public static ApplicationContext getApplicationContext() {
		return SpringContextUtil.applicationContext;
	}
	
	/**
	 * 获取实例
	 * @param name 实例名称
	 * 				如果某个类名称前两个字母都为大写，实例化的Bean名称和类名称保持一致
	 * 				如：类名称为PPSMenu
	 * 				获取方法：SpringContextUtil.getBean("PPSMenu");
	 * @return 实例
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	
//	public static void main(String[] args) {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		applicationContext.getBean("serviceName");
//	}
}
