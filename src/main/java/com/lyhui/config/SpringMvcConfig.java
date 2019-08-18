package com.lyhui.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = {"com.lyhui.controller"}) //扫描controller
public class SpringMvcConfig {

    //注册视图解析器
    @Bean

    public InternalResourceViewResolver resourceViewResolver() {
        InternalResourceViewResolver view = new InternalResourceViewResolver();
        view.setPrefix("/pages/");
        view.setSuffix(".jsp");
        return view;
    }
}
