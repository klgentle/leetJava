package com.klgentle.demo3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private Object object;

    public void setObject(Object object) {
        this.object = object;
    }

    public Object getObject() {
        return object;
    }

    // 生成得到代理类
    public java.lang.Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), object.getClass().getInterfaces(),this);
    }

    // 处理代理实例，并返回结果
    public java.lang.Object invoke(java.lang.Object proxy, Method method, java.lang.Object[] args) throws Throwable {

        seeHourse();
        // 动态代理的本质，就是使用反映
        java.lang.Object result = method.invoke(object, args);
        fare();
        return result;
    }

    public void seeHourse() {
        System.out.println("中介带你去看房");
    }

    public void fare() {
        System.out.println("中介收手续费");
    }
}
