package com.mabiao.mall.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 核心原理
 * 1）、@EnableRedisHttpSession导入RedisHttpSessionConfiguration配置
 *      1、给容器中添加了一个组件
 *          SessionRepository --> RedisOperationsSessionRepository --> Redis操作session，session的增删改查封装类
 *      2、SessionRepositoryFilter --> Filter: session存储过滤器；每个请求过来都必须经过filter
 *          1、创建的时候，就自动从容器中获取到了SessionRepository；
 *          2、原始的request，response都被包装。SessionRepositoryRequestWrapper, SessionRepositoryResponseWrapper
 *          3、以后取取session。request.getSession();
 *          // SessionRepositoryRequestWrapper
 *          4、wrappedRequest。getSession(); --> SessionRepository中获取到的。
 *
 * 装饰者模式
 * 自动延期；redis中的数据也是有过期时间的
 */

@EnableRedisHttpSession
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MallAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAuthServerApplication.class, args);
    }

}
