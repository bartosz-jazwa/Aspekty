package com.jazwa.aspekty.model;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@Aspect
@Component
public class CompanyAspect {
    Logger logger = LoggerFactory.getLogger(CompanyAspect.class);

    @Pointcut("execution(* com.jazwa.aspekty.model..get*())")
    public void getterPointCut(){}

    @Pointcut("execution(void com.jazwa.aspekty.model..set*(..))")
    public void setterPointCut(){}

    @Pointcut("execution(Company com.jazwa.aspekty.model.Company.Company*(..))")
    public void constructPoinCut(){}


    @Pointcut("execution(* com.jazwa.aspekty.model.CompanyController.*(..))")
    public void controllerPointCut(){}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    void annotatedPointcut(){}

    @Before("annotatedPointcut() && args(..,request)")
    void beforeAnnotatedRequest(HttpServletRequest request){}

    @AfterReturning("annotatedPointcut() && args(..,response)")
    void afterAnnotatedRequest(HttpServletResponse response){
        System.out.println(response.toString());
    }

    @Before("controllerPointCut()")
    public void beforeRequest(JoinPoint joinPoint){
        String controllerMethod = joinPoint.getSignature().toShortString();

        Arrays.stream(joinPoint.getArgs()).forEach(jp -> {
            logger.info("Argument metody " +controllerMethod+" = "+ jp);
        });
    }
    @AfterReturning(pointcut = "controllerPointCut()",returning = "result")
    public void returnedMessage(JoinPoint jp, Object result){
        logger.info("Rest "+jp.getSignature().toShortString()+" zwrocila "+ result.toString());
    }


    @AfterReturning(pointcut = "getterPointCut()",returning = "result")
    public void returningGetters(JoinPoint jp, Object result){
        logger.info("Metoda "+jp.getSignature().toShortString()+" zwrocila "+ result);
    }

    @Before("setterPointCut()")
    public void beforeSetters(JoinPoint jp){
        String setterMethod = jp.getSignature().toShortString();
        Arrays.stream(jp.getArgs()).forEach(jointPoint -> {
            logger.info("Ustawiam motodą " +setterMethod+" na "+ jointPoint);
        });
    }

    @Around("constructPoinCut()")
    public Company aroundConstruct(ProceedingJoinPoint joinPoint){
        String constructorMethod = joinPoint.getSignature().toShortString();
        logger.info("Konstruktor ", joinPoint.getArgs());

        Company company = null;

        try {
            company = (Company) joinPoint.proceed();
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }finally {
            logger.info(joinPoint.toShortString());
            return company;
        }
    }
}
