package com.springcloud.service.impl;

import com.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author : xiemogaminari
 * create at:  2020-05-29  02:24
 * @description: c
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentOK(Integer id) {
        return "服务降级_paymentOK_访问异常";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "服务降级_paymentTimeout_访问异常";
    }
}