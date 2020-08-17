package com.seoulit.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import common.interceptor.LoggerInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry  registry) {
		registry.addInterceptor(new LoggerInterceptor())
		.addPathPatterns("/api/**");
		// 제외 메서드 excludePathPatterns
		// .excludePathPatterns("/user/**");  
	}

}