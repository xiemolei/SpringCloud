package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author : xiemogaminari
 * create at:  2020-05-26  16:52
 * @description: controller
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value="/payment/zk")
    public String zk(){
        return "Zookeeper:"+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}