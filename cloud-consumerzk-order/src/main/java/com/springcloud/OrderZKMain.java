package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author : xiemogaminari
 * create at:  2020-05-26  18:06
 * @description: zk
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderZKMain.class,args);
    }
}