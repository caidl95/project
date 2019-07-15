package com.mmall.permission.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 拦截路径：必须登录才可以访问
		List<String> patterns = new ArrayList<>();
		patterns.add("/**");
		
		// 白名单：在黑名单范围内，却不需要登录就可以访问
		List<String> excludePatterns = new ArrayList<>();
		excludePatterns.add("/ztree/**");
		excludePatterns.add("/assets/**");
		excludePatterns.add("/bootstrap3.3.5/**");
		excludePatterns.add("/common/**");
		excludePatterns.add("/css/**");
		excludePatterns.add("/js/**");

		excludePatterns.add("/login");
		excludePatterns.add("/signin.html");
		
		// 注册拦截器
		registry
			.addInterceptor(new LoginInterceptor())
			.addPathPatterns(patterns)
			.excludePathPatterns(excludePatterns);
	}
	
}





