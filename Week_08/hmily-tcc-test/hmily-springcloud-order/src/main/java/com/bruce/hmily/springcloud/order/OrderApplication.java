package com.bruce.hmily.springcloud.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ImportResource;

/**
 * OrderApplication.
 *
 * @author bruce
 */
@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
@ImportResource({"classpath:applicationContext.xml"})
@MapperScan("com.bruce.hmily.common.order.mapper")
public class OrderApplication {

    /**
     * main.
     *
     * @param args args
     */
    public static void main(final String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
