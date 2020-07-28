package com.springcloud.controller;

import com.springcloud.entities.CommentResult;
import com.springcloud.entities.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author : xiemogaminari
 * create at:  2020-05-22  22:07
 * @description: payment控制器
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommentResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("******插入结果:"+result);
        if(result>0){
            return new CommentResult(200,"插入数据成功"+serverPort,result);
        }else
            return new CommentResult(0,"插入数据失败",result);
    }

    @GetMapping(value="/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id")  Long id){
        Payment payment=paymentService.getPaymentById(id);
        log.info("*********查询结果："+payment);
        if(payment!=null){
            return new CommentResult(200,"查询成功"+serverPort,payment);
        }else
            return new CommentResult(0,"没有对应的记录，查询ID："+id);
    }

    @GetMapping(value = "/payment/lb")
    public String PaymentLB(){
        return serverPort;
    }

    @GetMapping(value = "/payment/timeout")
    public String PaymentTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}