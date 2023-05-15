package com.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class ExceptionMetricAspect {

    private final Map<String, Long> exceptionCountMetrics = new HashMap<>();

    @AfterThrowing(throwing = "e",pointcut = "execution(* *.*(..))")
    public void exceptionCountAdvice(JoinPoint joinPoint, Throwable e) throws Throwable {
        String exceptionName = e.getClass().getName();
        exceptionCountMetrics.put(exceptionName, exceptionCountMetrics.getOrDefault(exceptionName, 0L) + 1);
        throw e;
    }

    public Map<String, Long> getMetrics() {
        return exceptionCountMetrics;
    }

}
