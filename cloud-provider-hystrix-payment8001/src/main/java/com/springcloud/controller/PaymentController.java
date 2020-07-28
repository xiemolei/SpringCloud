package com.springcloud.controller;

import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : xiemogaminari
 * create at:  2020-05-28  20:31
 * @description: c
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping(value="/payment/ok/{id}")
    public String paymentOK(@PathVariable("id") Integer id){
        String result=paymentService.paymentServiceOK(id);
        log.info("*********"+result);
        return result;
    }

    @GetMapping(value = "/payment/timeout/{id}")
    public String PaymentTimeOut(@PathVariable("id") Integer id){
        String result=paymentService.paymentServiceTimeout(id);
        log.info("##########"+result);
        return result;
    }

    //服务熔断
    @GetMapping(value = "/payment/circuit/{id}")
    public String PaymentCircuitBreaker(@PathVariable("id") Integer id){
        String result=paymentService.paymentCircuitBreaker(id);
        log.info("##########"+result);
        return result;
    }
}