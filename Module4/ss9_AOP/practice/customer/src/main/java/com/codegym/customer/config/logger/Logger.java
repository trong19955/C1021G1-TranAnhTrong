package com.codegym.customer.config.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import java.util.Arrays;


@Aspect
public class Logger {
    public void error(){
        System.out.println("[CMS] ERROR!");
    }
    @AfterThrowing(pointcut = "execution(public * com.codegym.customer.service.CustomerService.*(..))", throwing = "e")
    public void log(JoinPoint joinPoint, Exception e) {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, method, args, e.getMessage()));
    }

}
