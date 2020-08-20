package com.klgentle.demo4;

import com.klgentle.demo2.UserService;
import com.klgentle.demo2.UserServiceImp;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        UserServiceImp userService = new UserServiceImp();
        // 代理角色，不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 设置代理对象
        pih.setTarget(userService);
        // 动态生成代理类
        UserService proxy = (UserService) pih.getProxy();
        proxy.delete();
    }
}
