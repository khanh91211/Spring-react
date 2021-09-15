package com.it15301;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.it15301.interceptors.AuthenticateInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	@Autowired
	private AuthenticateInterceptor authenInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authenInterceptor)
			.addPathPatterns("/shopcat/admin/**", "/shopcat/user/**")
			.excludePathPatterns("shopcat/login","/regester");
	}
}
