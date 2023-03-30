package com.coh.aspect;

import org.aspectj.lang.JoinPoint;

import java.util.Arrays;

public class ErrorLog {
    public void show(JoinPoint joinPoint,Throwable throwable){
        System.out.println(
                joinPoint.getSignature().getName()+
                "----"+joinPoint.getTarget()+
                "----"+Arrays.toString(joinPoint.getArgs())+
                "----"+throwable.getMessage());
    }
}
