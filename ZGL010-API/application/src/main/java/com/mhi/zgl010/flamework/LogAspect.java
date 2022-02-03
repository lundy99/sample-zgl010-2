package com.mhi.zgl010.flamework;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.AfterThrowing;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Aspect
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);       

    /**
     * Controllerクラスのメソッド開始Logを出力する
     * @param jp
     */
    @Before("@within(org.springframework.web.bind.annotation.RestController)")       
    public void startLog(JoinPoint jp){
        logger.info("jp.getArgs:"+ Arrays.toString(jp.getArgs()));
        logger.info("jp.getClass:"+ jp.getClass().toString());
        logger.info("jp.getKind:"+ jp.getKind().toString());
        logger.info("jp.getSignature:"+ jp.getSignature().toString());
        logger.info("jp.getTarget:"+ jp.getTarget().toString());
    }
    /**
     * Controllerクラスのメソッド正常終了Logを出力する
     * @param jp
     */
    @AfterReturning(value="@within(org.springframework.web.bind.annotation.RestController)",returning="returnValue")       
    public void endLog(JoinPoint jp,Object returnValue){
        logger.info("jp.getArgs:"+ Arrays.toString(jp.getArgs()));
        logger.info("jp.getClass:"+ jp.getClass().toString());
        logger.info("jp.getKind:"+ jp.getKind().toString());
        logger.info("jp.getSignature:"+ jp.getSignature().toString());
        logger.info("jp.getTarget:"+ jp.getTarget().toString());

    }
        /**
     * Controllerクラスのメソッド正常終了Logを出力する
     * @param jp
     */
    @AfterThrowing(value="@within(org.springframework.web.bind.annotation.RestController)", throwing ="e")       
    public void errorLog(JoinPoint jp, Throwable e){
        logger.info("jp.getArgs:"+ Arrays.toString(jp.getArgs()));
        logger.info("jp.getClass:"+ jp.getClass().toString());
        logger.info("jp.getKind:"+ jp.getKind().toString());
        logger.info("jp.getSignature:"+ jp.getSignature().toString());
        logger.info("jp.getTarget:"+ jp.getTarget().toString());
        logger.error("jp.e:", e);
        e.getStackTrace();
    }
}
