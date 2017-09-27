package com.cloud.server.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

//@Configuration
public class DruidConfiguration {
	Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);

	/**
	 * 注册Servlet
	 */
//	@Bean
	ServletRegistrationBean statViewServlet() {
		logger.debug("init servletRegistrationBean configuration");
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		//IP白名单
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1,192.168.2.221");
		//IP黑名单 （同时出现时，deny优先于allow）
		servletRegistrationBean.addInitParameter("deny", "192.168.2.2");
		//控制台管理用户
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "123456");
		//是否能够重置数据，禁用HTML页面上的“Reset All”功能
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;
	}
	
	/**
	 * 注册Filter
	 */
//	@Bean
	FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		//添加过滤规则
		filterRegistrationBean.addUrlPatterns("/*");
//		filterRegistrationBean.addUrlPatterns("*.do");
		//添加不需要忽略的格式信息
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
	
	/**
	 * @Primary注解作用：存在多个DataSource时，该DataSource被优先使用、
	 */
//	@Bean
//	@Primary
	DataSource druidDataSource(@Value("${spring.datasource.driver-class-name}") String driver, 
			@Value("${spring.datasource.url}") String url, 
			@Value("${spring.datasource.username}") String username, 
			@Value("${spring.datasource.password}") String password) {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(driver);
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
		try {
			//监控统计用的filter:stat 
			//日志用的filter:log4j
			//防御SQL注入的filter:wall
			druidDataSource.setFilters("stat, wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		logger.debug("init druid data source Configuration");
		return druidDataSource;
	}
	
}
