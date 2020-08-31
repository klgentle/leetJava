package com.klgentle.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AnnotationPointCut {

    @Before("execution(* com.klgentle.service.UserServiceImpl.*(..))")
    public void befor() {
        System.out.println("----- before method2 -----");
    }

    @After("execution(* com.klgentle.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("--------after method2----------");
    }

    @Around("execution(* com.klgentle.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("----around before----");
        Object proceed = jp.proceed();
        System.out.println("----around after----");
    }
}
