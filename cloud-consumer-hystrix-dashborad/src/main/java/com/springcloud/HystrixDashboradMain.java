package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author : xiemogaminari
 * create at:  2020-05-31  20:39
 * @description: m
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboradMain {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboradMain.class,args);
    }
}