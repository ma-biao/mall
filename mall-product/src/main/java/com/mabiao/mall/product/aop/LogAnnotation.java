package com.mabiao.mall.product.aop;

import java.lang.annotation.*;

/**
 * log自定义实现注解
 * 切点PointCut
 * @author 马彪
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogAnnotation {

    String module() default "";

    String operator() default "";
}
