package com.example.demo;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**") // apply to all paths
                .allowedOrigins("http://localhost:3000") // allowed origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // allowed methods
                .allowedHeaders("*") // allowed headers
                .allowCredentials(true); // allow credentials
    }
}
