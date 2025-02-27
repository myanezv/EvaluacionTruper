package com.evaluacion.truper.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.evaluacion.truper.interceptor.PerformanceInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	 @Autowired
	 private PerformanceInterceptor performanceInterceptor;

	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
		 registry.addInterceptor(performanceInterceptor).addPathPatterns("/**");  // Aplica a todas las rutas
	 }
}
