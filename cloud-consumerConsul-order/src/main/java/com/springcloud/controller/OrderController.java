package com.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author : xiemogaminari
 * create at:  2020-05-26  21:48
 * @description: controller
 */
@RestController
public class OrderController {
    @Resource
    private RestTemplate restTemplate;

    private String paymentService="http://cloud-provider-payment";

    @GetMapping(value="/order/consul")
    public String order(){
        return restTemplate.getForObject(paymentService+"/payment/consul",String.class);
    }
}