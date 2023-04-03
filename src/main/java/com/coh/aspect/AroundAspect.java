package com.coh.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAspect {
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("around开始");
        proceedingJoinPoint.proceed();
        System.out.println("around结束");
    }
}
