package com.example.expenseTracker.Aspect;

import java.util.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
//    @Before("execution (* com.example.expenseTracker.Service.ExpenseService.*(..))")
//    public void before(JoinPoint joinPoint){
//        System.out.println("ExpenseService method is about to execute");
//        System.out.println("Method called :"+ joinPoint.getSignature().getName());
//        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));
//    }
//    @AfterReturning(value = "execution (* com.example.expenseTracker.Service.ExpenseService.*(..))",
//    returning = "result")
//    public void afterReturning(JoinPoint joinPoint,Object result){
//        System.out.println("Method returned: "+result);
//    }
    @Around("execution(* com.example.expenseTracker.Service.ExpenseService.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object result=joinPoint.proceed();
        long endTime=System.currentTimeMillis();
        long executionTime=endTime-startTime;
        System.out.println(
                "Method: " + joinPoint.getSignature().getName()
                        + " | Execution time: " + executionTime + " ms"
        );
        return result;
    }
}
