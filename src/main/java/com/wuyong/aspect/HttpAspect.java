package com.wuyong.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 切点
 * Created by 坚果
 * on 2017/6/24
 */
@Aspect
@Component
public class HttpAspect {

    public static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Pointcut("execution(public * com.wuyong.controller.*.*(..))")
    public void log() {

    }

    @Before("log()")
    public void logStart(JoinPoint joinPoint) {
        logger.info("开始记录");
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        //url
        logger.info("url:{}", request.getRequestURL());
        //method
        logger.info("方法是:{}", request.getMethod());
        //ip
        logger.info("IP地址是：{}", request.getRemoteAddr());
        //类方法
        logger.info("类方法是：{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("arg:{}", Arrays.toString(joinPoint.getArgs()));

    }

    @After("log()")
    public void logEnd() {

        logger.info("结束记录");
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void logReturning(Object object) {
        logger.info("response={}", object.toString());
    }

}
