package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /uploads/ 경로에 대한 정적 리소스 제공
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:uploads/");  // 서버 내의 uploads 폴더 경로
    }
}
