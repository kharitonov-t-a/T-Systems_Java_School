package com.web.shop.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class ServiceLogger {

    private static final org.apache.log4j.Logger LOG = Logger.getLogger(ServiceLogger.class.getName());

    @Pointcut("execution(* com.web.shop.service..*.*(..))")
    public void serviceMethod() { }

    @Around("serviceMethod()")
    public Object logServiceCall(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        String classsName = thisJoinPoint.getSignature().getDeclaringTypeName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        LOG.info("Call method " + classsName + "." + methodName + " with args:");
        Arrays.stream(methodArgs).forEach(e -> LOG.info("ARGUMENT: " + e));

        Object result = thisJoinPoint.proceed();

        LOG.info("Method " + classsName + "." + methodName + " returns " + result);

        return result;
    }
}
