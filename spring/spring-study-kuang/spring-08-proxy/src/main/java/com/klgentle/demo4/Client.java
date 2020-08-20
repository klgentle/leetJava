package com.klgentle.demo4;

import com.klgentle.demo2.UserServiceImp;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        UserServiceImp userServiceImp = new UserServiceImp();
        // 代理角色，不存在
        ProxyInvocationHandler pih = new ProxyInvocationHandler();

    }
}
