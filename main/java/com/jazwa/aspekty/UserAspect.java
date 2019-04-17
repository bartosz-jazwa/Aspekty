package com.jazwa.aspekty;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {
    Logger log = LoggerFactory.getLogger(UserAspect.class);

    @Before("beforPointCut()")
    public void beforeUpper(){
        log.info("Przed metoda upper");
    }

    @AfterReturning(pointcut="beforPointCut()",returning="result")
    public void returningName(JoinPoint joinPoint,String result){

        log.info("Zwrocono "+result + " dla metody "+ joinPoint.toShortString());
    }

    @Around("beforPointCut()")
    public Object aroundName(ProceedingJoinPoint point){
        log.info("Przed");
        Object object = null;
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            log.info("po");
            return object;
        }
    }

    @AfterThrowing(value = "execution(* com.jazwa.aspekty.UserService.*(..))",throwing = "e")
    public void afterThrow(Throwable e){
        log.error("Blad", e);
    }

    @Pointcut("execution(public String getUpperName())")
    public void beforPointCut(){}

}
