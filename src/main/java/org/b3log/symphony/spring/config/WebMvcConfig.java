package org.b3log.symphony.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring MVC 配置类，这里只配置静态资源
 * 这里使用的@Configuration注解，注意不要用MVC的@EnableWebMvc,
 * @EnableWebMvc注解会使sping boot默认关于webmvc的配置都会失效
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 重写路径配置方法，添加自定义的路径
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/templates/** 访问都映射到classpath:/templates/ 目录下
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
        //将所有/static/** 访问都映射到classpath:/templates/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");


    }

}
