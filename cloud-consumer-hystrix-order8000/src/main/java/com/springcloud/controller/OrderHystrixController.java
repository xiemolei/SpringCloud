package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : xiemogaminari
 * create at:  2020-05-28  21:23
 * @description: c
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "globalFallback")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/ok/{id}")
    //@HystrixCommand//不指定配置 用globalFallback
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        //int age=10/0;
        return paymentHystrixService.paymentOK(id);
    }

    @GetMapping("/consumer/payment/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_",commandProperties =  {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")})
    public String paymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentHystrixService.paymentTimeout(id);
    }

    public String paymentInfo_Timeout_(@PathVariable("id") Integer id){
        return "线程组："+Thread.currentThread().getName()+" consumer超时，id："+id+"Q_Q...";
    }

    public String globalFallback(){
        return " consumer____请求超时Q_Q...请稍后再试";
    }
}