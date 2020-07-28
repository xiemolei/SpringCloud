package com.springcloud.controller;

import com.springcloud.service.PaymentFeignService;
import com.springcloud.entities.CommentResult;
import com.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : xiemogaminari
 * create at:  2020-05-28  16:14
 * @description: c
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return  paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/paymnet/timeout")
    public String paymentTimeOut(){
        return paymentFeignService.PaymentTimeOut();
    }
}