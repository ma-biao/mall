package com.mabiao.mall.product.aop;

import com.alibaba.fastjson.JSON;
import com.mabiao.mall.product.aop.utils.HttpContextUtils;
import com.mabiao.mall.product.aop.utils.IpUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Component
@Aspect /* 切面 定义了通知和切点的关系 */
@Slf4j
public class LogAspect {

    /**
     * 切点
     */
    @Pointcut("@annotation(com.mabiao.mall.product.aop.LogAnnotation)")
    public void pt(){}

    /**
     * 通知类
     * 环绕通知（方法前后）
     */
    @Around("pt()")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = proceedingJoinPoint.proceed();
        // 执行时长（毫秒）
        long time = System.currentTimeMillis() - beginTime;
        // 保存日志
        recordLog(proceedingJoinPoint, time);
        return result;
    }

    private void recordLog(ProceedingJoinPoint proceedingJoinPoint, long time) {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod();
        LogAnnotation logAnnotation = method.getAnnotation(LogAnnotation.class);
        log.info("=========================log start=========================");
        log.info("module: {}", logAnnotation.module());
        log.info("operation: {}", logAnnotation.operator());

        // 请求的方法名
        Object[] args = proceedingJoinPoint.getArgs();
        // String params = JSON.toJSONString(args[0]);
        String params = JSON.toJSONString(args);
        log.info("params: {}", params);

        // 获取request 设置IP地址
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        log.info("ip: {}", IpUtils.getIpAddr(request));

        log.info("excute time: {} ms", time);
        log.info("=========================log end=========================");
    }
}
