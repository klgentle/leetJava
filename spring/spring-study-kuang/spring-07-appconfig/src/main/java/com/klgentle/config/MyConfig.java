package com.klgentle.config;

import com.klgentle.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// @Configuration 会被Spring管理，注册到容器中
// @Configuration 代表这是一个配置类，类似于beans.xml
@Configuration
@ComponentScan("com.klgentle.pojo")
@Import(KlgentleConfig.class)
public class MyConfig {

    @Bean // 注册一个bean， 相当于一个bean标签
    public User user() {
        return new User();
    }
}
