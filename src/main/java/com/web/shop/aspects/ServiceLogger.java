package com.web.shop.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.testng.log4testng.Logger;

import java.util.Arrays;

@Component
@Aspect
public class ServiceLogger {

    static Log  LOG  = LogFactory.getLog(ServiceLogger.class.getName());

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
