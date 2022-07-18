package com.tang.telecom.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author weepppp 2022/7/18 14:50
 **/

@Configuration
public class TelecomConfig implements WebMvcConfigurer {

    //如果在spring-boot-----把页面跳转的请求映射到页面的写法

    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("njdsnklfdklfndsklfn");
        registry.addViewController("/account").setViewName("account");
        registry.addViewController("/customer").setViewName("customer");
        registry.addViewController("/phone").setViewName("phone");
        registry.addViewController("/bill").setViewName("bill");
        registry.addViewController("/billClient").setViewName("billClient");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index").setViewName("index");
    }
}
