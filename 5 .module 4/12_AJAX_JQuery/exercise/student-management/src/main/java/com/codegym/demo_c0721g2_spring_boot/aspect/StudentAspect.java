package com.codegym.demo_c0721g2_spring_boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StudentAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("execution(* com.codegym.demo_c0721g2_spring_boot.controller.StudentController.*(..))")
    public void logAfterMethodCall(JoinPoint joinPoint) {
        String nameMethod = joinPoint.getSignature().getName();
        logger.info("Tên phương thức" + nameMethod);
    }
}
