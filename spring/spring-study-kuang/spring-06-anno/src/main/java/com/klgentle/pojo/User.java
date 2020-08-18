package com.klgentle.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 等价于 <bean id="user" class="..."/>
@Component
public class User {
    @Value("klgentle")
    public String name;

}
