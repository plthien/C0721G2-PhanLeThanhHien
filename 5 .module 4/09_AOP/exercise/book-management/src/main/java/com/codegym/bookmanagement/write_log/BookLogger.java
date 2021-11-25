package com.codegym.bookmanagement.write_log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class BookLogger {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(pointcut = "execution(public * com.codegym.bookmanagement.service.IBookService.increaseQuantity(..))")
    public void logIncreaseBook(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        logger.info("Method name: " +method);
    }

    @AfterReturning(pointcut = "execution(public * com.codegym.bookmanagement.service.IBookService.decreaseQuantity(..))")
    public void logDecreaseBook(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        logger.info("Method name: " +method);
    }
}
