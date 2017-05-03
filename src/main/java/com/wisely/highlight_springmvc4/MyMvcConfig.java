package com.wisely.highlight_springmvc4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.wisely.highlight_springmvc4.interceptor.DemoInterceptor;

@Configuration
@EnableWebMvc //开启一些配置 如ViewResolver
@ComponentScan("com.wisely.highlight_springmvc4")
public class MyMvcConfig extends WebMvcConfigurerAdapter{
	
	@Bean //Check your ViewResolver setup!
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/classes/views/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}
	
	//继承一个类 定制配置
	//配置静态资源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		//前面是访问路径 后面是文件路径
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
	}
	
	@Bean
	public DemoInterceptor demoInterceptor(){
		return new DemoInterceptor();
	}
	
	//注册拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(demoInterceptor());
	}
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer){
		configurer.setUseSuffixPatternMatch(false);
	}
	
}
