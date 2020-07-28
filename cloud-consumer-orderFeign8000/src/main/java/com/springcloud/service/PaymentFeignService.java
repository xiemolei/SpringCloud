package com.springcloud.service;

import com.springcloud.entities.CommentResult;
import com.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : xiemogaminari
 * create at:  2020-05-28  16:07
 * @description: i
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value="/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id")  Long id);

    @GetMapping(value = "/payment/timeout")
    public String PaymentTimeOut();
}
