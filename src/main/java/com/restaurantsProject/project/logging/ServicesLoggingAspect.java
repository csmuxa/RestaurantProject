package com.restaurantsProject.project.logging;


import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.Date;


@Aspect
@Configuration
public class ServicesLoggingAspect {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.restaurantsProject.project.services.*.*.*(..))")
    public void daoMethods() {
    }


    @Before("daoMethods()")
    public void BeforeAdvice(JoinPoint joinPoint) {
        logger.debug("inserting\t" + joinPoint.getTarget());
    }

    @After("daoMethods()")
    public void AfterAdvice(JoinPoint joinPoint) {
        logger.debug("inserted successfully\t" + joinPoint.getTarget());
    }

    @Around("daoMethods()")
    public Object AroundAdvice(ProceedingJoinPoint joinPoint) {
        Long before = System.currentTimeMillis();
        Object o = null;

        try {
            o = joinPoint.proceed();
        } catch (Throwable throwable) {

        }
        Long after = System.currentTimeMillis();
        System.out.println("Time of methods execution : " + (after - before) + "milliseconds");
        return o;
    }
}
