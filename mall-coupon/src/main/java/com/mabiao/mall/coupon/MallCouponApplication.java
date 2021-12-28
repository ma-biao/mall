package com.mabiao.mall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 如何使用Nacos作为配置中心统一管理配置
 * 1. 引入依赖
 * 2. 创建bootstrap.properties
 * 3. 需要给配置中心默认添加一个 数据集(Data Id){应用名.properties}
 * 4. 给 应用名.properties 添加任何配置
 * 5. 动态获取配置：@RefreshScope动态获取并刷新配置; @Value("${配置项的名}"):获取配置
 *      如果配置中心和当前应用的配置文件中都配置了相同的项，优先使用配置中心的配置
 *
 * 细节：
 * 1. 命名空间：配置隔离
 *      默认：public(保留空间)；默认新增的所有配置都在public空间。
 *      1) 开发，测试，生产：利用命名空间来做环境隔离。
 *         注意：在bootstrap.properties配置上，需要使用哪个命名空间下的配置
 *         spring.cloud.nacos.config.namespace=...
 *      2) 每一个微服务之间相互隔离配置，每一个微服务都创建自己的命名空间，只加载自己命名空间下的所有配置
 * 2. 配置集：所有的配置的集合
 * 3. 配置集ID：类似于配置文件名 Data Id
 * 4. 配置分组：
 *      默认所有的配置集都属于DEFAULT_GROUP
 *
 * 每个微服务创建自己的命名空间，使用配置分组区分环境：dev,test,prod
 *
 * 同时加载多个配置集：
 * 1) 微服务任何配置信息，任何配置文件都可以放在配置中心；
 * 2) 只需要在bootstrap.properties中，说明加载配置中心的哪些配置文件即可；
 * 3) @Value, @ConfigurationProperties。都可以用来获取配置中心中所配置的信息；
 * 4) 配置中心有的优先使用配置中心中的，没有则使用本地的配置。
 *
 */

@EnableDiscoveryClient
@SpringBootApplication
public class MallCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallCouponApplication.class, args);
    }

}
