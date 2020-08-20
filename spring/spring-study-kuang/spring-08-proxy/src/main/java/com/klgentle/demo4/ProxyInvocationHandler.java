package com.klgentle.demo4;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private java.lang.Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    public Object getTarget() {
        return target;
    }

    // 生成得到代理类
    public java.lang.Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    // 处理代理实例，并返回结果
    public java.lang.Object invoke(java.lang.Object proxy, Method method, java.lang.Object[] args) throws Throwable {

        java.lang.Object result = method.invoke(target, args);
        return result;
    }

}
