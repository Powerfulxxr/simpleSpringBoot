package com.ss.p;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.ss.p.mapper")
public class PApplication extends SpringBootServletInitializer {
	
	private static Class<PApplication> applicationClass = PApplication.class;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		builder.listeners();
		return builder.sources(applicationClass);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}
}
