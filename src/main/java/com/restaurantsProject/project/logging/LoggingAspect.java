package com.restaurantsProject.project.logging;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class LoggingAspect {

    private Logger logger = LogManager.getLogger(this.getClass());
    @Pointcut("execution(* com.restaurantsProject.project.services.foodService.FoodServiceImpl.*(..))")
    public void daoMethods() {}


    @Before("daoMethods()")
    public void loggingAdvice(JoinPoint joinPoint){
        logger.info("inserted");
    }
}
