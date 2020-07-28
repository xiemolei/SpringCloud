package com.springcloud.alibaba.service;

import com.springcloud.entities.CommentResult;
import com.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author : xiemogaminari
 * create at:  2020-07-09  22:50
 * @description:
 */
@Component
public class PaymentFallbackService implements  PaymentService{
    @Override
    public CommentResult<Payment> paymentSQL(Long id)
    {
        return new CommentResult<>(44444,"服务降级返回,---PaymentFallbackService",new Payment(id,"errorSerial"));
    }
}