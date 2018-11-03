package com.web.shop.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionLogger {

    static Log LOG  = LogFactory.getLog(ServiceLogger.class.getName());

    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void transactMethod() { }

    @Around("transactMethod()")
    public Object logTransactionCall(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        LOG.debug("<-- START TRANSACTION METHOD -->");
        Exception ex = null;
        try {
            return thisJoinPoint.proceed();
        } catch (Exception e) {
            ex = e;
            throw e;
        } finally {
            if (ex != null) {
                LOG.debug("<-- ROLLBACK TRANSACTION METHOD -->");
            } else {
                LOG.debug("<-- CLOSE TRANSACTION METHOD -->");
            }
        }
    }
}
