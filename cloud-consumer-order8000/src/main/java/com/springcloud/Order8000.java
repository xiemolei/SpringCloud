package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : xiemogaminari
 * create at:  2020-05-23  16:12
 * @description: 消费者启动类
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyLoadbalanceRule.class)
public class Order8000 {
    public static void main(String[] args) {
        SpringApplication.run(Order8000.class,args);
    }

}