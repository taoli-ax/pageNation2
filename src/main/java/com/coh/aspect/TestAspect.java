package com.coh.aspect;


import org.aspectj.lang.JoinPoint;

public class TestAspect {
    public void start(JoinPoint joinpoint){
        System.out.println("aop staring");
    }
    public void end(JoinPoint joinpoint,Object result){
        System.out.println("aop ending");
    }
}
