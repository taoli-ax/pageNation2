package com.coh.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogAroundAspect {
    @Around("execution(* com.coh.service..*.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("aop around 开始");
        Object proceed=proceedingJoinPoint.proceed();
        System.out.println("aop around 结束"+proceed);
    }
}
