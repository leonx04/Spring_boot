package com.example.buoi_1.repository.asm1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor)
                .addPathPatterns("/san-pham/**", "/nhan-vien/**", "/khach-hang/**",
                        "/hoa-don/**",
                        "/hoa-don-chi-tiet/**",
                        "/san-pham-chi-tiet/**",
                        "/mau-sac/**",
                        "/kich-thuoc/**")
                .excludePathPatterns("/login", "/home");
    }
}