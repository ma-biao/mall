package com.mabiao.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 1. 整合Mybatis-Plus
 *  1.1) 导入依赖
 *  1.2) 配置
 *      1.2.1) 配置数据源
 *          1.2.1.1) 导入数据库的驱动
 *          1.2.1.2) 在application.yml配置数据源
 *      1.2.2) 配置Mybatis-Plus
 *          1.2.2.1) 主类使用@MapperScan
 *          1.2.2.2) 告诉Mybatis-Plus SQL映射文件位置
 *
 * 2. 使用MyBatis-Plus进行逻辑删除
 *  2.1) 配置全局的逻辑删除规则（省略）
 *  2.2) 配置逻辑删除的组件Bean（省略）
 *  2.3) 加上逻辑删除的注解@TableLogic
 *
 * 8. 整合SpringCache简化缓存开发
 *  8.1) 引入依赖
 *       spring-boot-starter-cache、spring-boot-starter-data-redis
 *  8.2) 写配置
 *      8.2.1) 自动配置了哪些
 *          CacheAutoConfiguration会导入RedisCacheConfiguration
 *          自动配置好了缓存管理器RedisCacheManager
 *      8.2.2) 配置使用Redis作为缓存
 *  8.3) 测试使用缓存
 *      @Cacheable ：触发将数据保存到缓存的操作
 *      @CacheEvict ：触发将数据从缓存删除的操作
 *      @CachePut ： 不影响方法执行更新缓存
 *      @Caching ：组合以上多个操作
 *      @CacheConfig ： 在类级别共享缓存的相同配置
 *      8.3.1) 开启缓存功能 @EnableCaching
 *      8.3.2) 只需要使用注解就能完成缓存操作
 *  8.4) 原理：
 *      CacheAutoConfiguration -> RedisCacheConfiguration -> 自动配置了RedisCacheManager
 *      -> 初始化所有的缓存 -> 每个缓存决定使用什么配置 -> 如果redisCacheConfiguration有就用已有的，没有就用默认配置
 *      -> 想改缓存的配置，只需要给容器中放一个RedisCacheConfiguration
 */

@EnableRedisHttpSession
@EnableCaching
@EnableFeignClients(basePackages = "com.mabiao.mall.product.feign")
@MapperScan("com.mabiao.mall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class MallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class, args);
    }

}
