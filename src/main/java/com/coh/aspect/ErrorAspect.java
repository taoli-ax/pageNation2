package com.coh.aspect;

import org.aspectj.lang.JoinPoint;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ErrorAspect {
    public  void  ErrorLog(JoinPoint joinPoint,Throwable throwable){
        System.out.println("异常!....");
        System.out.println(
                joinPoint.getSignature().getName()
                +"----"+joinPoint.getTarget()
                +"=------="+ Arrays.toString(joinPoint.getArgs())
                +"----"+throwable.getMessage());
    }
}
