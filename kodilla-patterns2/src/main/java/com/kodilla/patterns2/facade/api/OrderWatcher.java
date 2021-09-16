package com.kodilla.patterns2.facade.api;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class OrderWatcher {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderWatcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(orderDto, userId) && target(object)")
    public void logEvents(OrderDto orderDto, Long userId, Object object){
        LOGGER.info("Logging the event: \n" +
                "Class :" + object.getClass().getName()+
                "\nOrder size: " + orderDto.getItems().size()+
                "\nUser ID: "+ userId.toString());
    }

    @Around("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint)throws Throwable{
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed: " + (end - begin) + "[ms]");
        }catch (Throwable e){
            LOGGER.error(e.getMessage());
            throw e;
        }
        return result;
    }
}
