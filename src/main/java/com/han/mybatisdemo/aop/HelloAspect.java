package com.han.mybatisdemo.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class HelloAspect {

    private final static Logger LOGGER = Logger.getLogger(HelloAspect.class);

    @Pointcut("execution(* com.han.mybatisdemo..*.*(..))")
    public void pointcut(){

    }

//    @Before(value = "pointcut()")
//    public void beforeAspect(JoinPoint joinPoint){
//        LOGGER.info("Before aspect do ....................{"+joinPoint.getSignature().getName()+"}");
//    }
//
//    @After(value = "pointcut()")
//    public void afterAspect(JoinPoint joinPoint){
//        LOGGER.info("After aspect do ....................{"+joinPoint.getSignature().getName()+"}");
//    }
//
//    @AfterThrowing(value = "pointcut()")
//    public void afterThrowing(JoinPoint joinPoint){
//        LOGGER.info("After throwing aspect do ....................{"+joinPoint.getSignature().getName()+"}");
//    }
//
//    @AfterReturning(value = "pointcut()")
//    public void afterReturning(JoinPoint joinPoint){
//        LOGGER.info("After returning aspect do ....................{"+joinPoint.getSignature().getName()+"}");
//    }

    @Around(value = "pointcut()")
    public void around(ProceedingJoinPoint joinPoint){
        try {
            LOGGER.info("Before aspect do ....................{"+joinPoint.getSignature().getName()+"}");
            LOGGER.info("Before aspect do....."+ Arrays.toString(joinPoint.getArgs()));
            joinPoint.proceed();
            LOGGER.info("After aspect do ....................{"+joinPoint.getSignature().getName()+"}");
        } catch (Throwable e) {
            e.printStackTrace();
            LOGGER.info("After throwing aspect do ....................{"+joinPoint.getSignature().getName()+"}");
        } finally {
            LOGGER.info("After returning aspect do ....................{"+joinPoint.getSignature().getName()+"}");
        }
    }


}
