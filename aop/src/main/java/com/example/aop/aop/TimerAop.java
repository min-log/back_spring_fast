package com.example.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimerAop {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    public void cut(){}


    ///타이머 어노테이션
    @Pointcut("@@annotation(com.example.aop.annotation.Timer)")
    public void enableTimer(){

    }
}
