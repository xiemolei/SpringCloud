package com.springcloud.service;

import com.springcloud.service.impl.PaymentHystrixServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author : xiemogaminari
 * create at:  2020-05-28  21:19
 * @description: i
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentHystrixServiceImpl.class)
public interface PaymentHystrixService {
    @GetMapping(value="/payment/ok/{id}")
    public String paymentOK(@PathVariable("id") Integer id);

    @GetMapping(value="/payment/timeout/{id}")
    public String paymentTimeout(@PathVariable("id") Integer id);
}
