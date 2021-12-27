package com.mabiao.mall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

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
 */

@MapperScan("com.mabiao.mall.product.dao")
@EnableDiscoveryClient
@SpringBootApplication
public class MallProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductApplication.class, args);
    }

}
