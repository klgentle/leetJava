package com.klgentle.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// 等价于 <bean id="user" class="..."/>
@Component
@Scope("prototype")
public class User {

    @Value("klgentle")
    public String name;

}
