package com.app.tpl.console.configuration;

import com.app.tpl.console.ApiInceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public ApiInceptor apiInceptor() {
		return new ApiInceptor();
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//校验用户登录
		registry.addInterceptor(apiInceptor())
				.addPathPatterns("/console/**")
				.excludePathPatterns("/console/login")
				.excludePathPatterns("/console/logout");

	}

}
