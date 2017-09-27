package com.cloud.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidConfiguration {

	@Bean
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
			druidDataSource.setFilters("stat, wall");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return druidDataSource;
	}
	
	
	
	
}
