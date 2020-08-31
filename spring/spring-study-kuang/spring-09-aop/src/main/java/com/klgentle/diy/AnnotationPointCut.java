package com.klgentle.diy;

// 使用方式三：使用注解方式实现AOP

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect // 标注这个类是一个切面
public class AnnotationPointCut {
    @Before("execution(* com.klgentle.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("------ before method ----");
    }

    @After("execution(* com.klgentle.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("------ after method ----");
    }

    @Around("execution(* com.klgentle.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        System.out.println("signature:" + jp.getSignature());
        // 执行方法
        Object proceed = jp.proceed();
        System.out.println("环绕后");
    }
}
