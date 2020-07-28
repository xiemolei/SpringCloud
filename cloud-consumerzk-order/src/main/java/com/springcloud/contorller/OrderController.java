package com.springcloud.contorller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : xiemogaminari
 * create at:  2020-05-26  18:10
 * @description: contorller
 */
@RestController
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;
    private String payment="http://cloud-provider-payment";

    @GetMapping(value="/order/zk")
    public String order(){
        return restTemplate.getForObject(payment+"/payment/zk",String.class);
    }
}