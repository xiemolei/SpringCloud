package com.springcloud.service.impl;

import com.springcloud.dao.PaymentDao;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : xiemogaminari
 * create at:  2020-05-22  21:58
 * @description: paymentService实现
 */
@Service
public class PaymentServiceImpl implements PaymentService {
//    @Resource
//    private PaymentDao paymentDao;
//
//    public int create(Payment payment){
//        return paymentDao.create(payment);
//    };
//
//    public Payment getPaymentById(Long id){
//        return paymentDao.getPaymentById(id);
//    };
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment)
    {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id)
    {
        return paymentDao.getPaymentById(id);
    }
}