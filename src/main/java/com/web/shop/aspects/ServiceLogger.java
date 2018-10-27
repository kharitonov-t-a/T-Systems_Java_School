package com.web.shop.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.testng.log4testng.Logger;

@Aspect
public class ServiceLogger {
//    private final static Logger LOG =
//            Logger.getLogger(ServiceLogger.class);
    private final Log LOG = LogFactory.getLog(this.getClass());

    @Pointcut("execution(* com.web.shop.service..*.*(..))")
    public void serviceMethod() { }

    @Around("serviceMethod()")
    public Object logServiceCall(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        String methodName = thisJoinPoint.getSignature().getName();
        Object[] methodArgs = thisJoinPoint.getArgs();

        LOG.debug("Call method " + methodName + " with args " + methodArgs);

        Object result = thisJoinPoint.proceed();

        LOG.debug("Method " + methodName + " returns " + result);

        return result;
    }
}
