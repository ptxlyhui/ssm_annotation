package com.lyhui.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/*
* 全注解开发，总的配置类
* */
@Configuration
@ComponentScan(basePackages = {"com.lyhui.service"})
@Import({MybatisConfig.class,SpringMvcConfig.class})  //导入其他配置类
@EnableWebMvc   //json转换
public class AppConfig implements WebMvcConfigurer {

    //json转换
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //添加额外消息转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypes);
        converters.add(converter);

    }

    /*
     * 或者注释掉上面的extendMessageConverters方法
     * 使用下面两个方法
     * */
/*    @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        //设置日期
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd");
        converter.setFastJsonConfig(fastJsonConfig);
        //设置啥玩意
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypes);
        return converter;
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //添加额外的消息转换器
        converters.add(fastJsonHttpMessageConverter());
    }*/


    //静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
