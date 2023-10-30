package com.zhouyunji.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


//@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
//    @Override
//    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
//        viewControllerRegistry.addViewController("/index.html").setViewName("login");
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(new LoginHandlerInterceptor())
            .addPathPatterns("/**")
            .excludePathPatterns("/login/*")
            .excludePathPatterns("/static/**")
            .excludePathPatterns("/hello/**")
            .excludePathPatterns("/favicon.ico")
            .excludePathPatterns("/");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/favicon.ico")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/META-INF/resources/");
    }
}
