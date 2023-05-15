package com.example.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class MethodInvokeMetricAspect {
    private static final Logger logger = LoggerFactory.getLogger(MethodInvokeMetricAspect.class);

    private final Map<String,Long> methodInvokeCountMetrics=new HashMap<>();

    @After("execution(* *(..))")
    public void countMetric(JoinPoint joinPoint) {
        String methodName=joinPoint.getSignature().getName();
        methodInvokeCountMetrics.put(methodName,methodInvokeCountMetrics.getOrDefault(methodName,0L)+1);
    }

    public Map<String,Long> getMetrics() {
        return methodInvokeCountMetrics;
    }

}
