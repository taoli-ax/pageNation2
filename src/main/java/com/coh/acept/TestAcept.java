package com.coh.acept;


import org.aspectj.lang.JoinPoint;

public class TestAcept {
    public void start(JoinPoint joinpoint){
        System.out.println("aop staring");
    }
    public void end(JoinPoint joinpoint,Object result){
        System.out.println("aop ending");
    }
}
