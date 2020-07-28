package com.springcloud.controller;

import com.springcloud.Lb.MyLb;
import com.springcloud.entities.CommentResult;
import com.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author : xiemogaminari
 * create at:  2020-05-23  16:21
 * @description: s
 */
@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private MyLb myLb;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value="/consumer/payment/create")
    public CommentResult create(Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommentResult.class);
    }

    @GetMapping(value="/consumer/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommentResult.class);
    }

    @GetMapping(value="/consumer/payment/getentities/{id}")
    public CommentResult<Payment> getPaymentById2(@PathVariable("id") Long id){
         ResponseEntity<CommentResult> entity=restTemplate.getForEntity(PAYMENT_URL+"/payment/get/"+id,CommentResult.class);
         if(entity.getStatusCode().is2xxSuccessful()){
             log.info(entity.getStatusCode()+"\t"+entity.getHeaders());
             return entity.getBody();
         }else {
             return new CommentResult<>(444,"查询失败");
         }
    }

    @GetMapping(value = "/order/lb")
    public String getPaymentPort(){
        List<ServiceInstance> instances=discoveryClient.getInstances("cloud-payment-service");
        if(instances==null || instances.size()==0){
            return "payment服务位注册";
        }else {
            ServiceInstance serviceInstance=myLb.getServiceInstance(instances);
            URI uri=serviceInstance.getUri();
            log.info(serviceInstance.getHost()+"\t"+serviceInstance.getUri());
            return  restTemplate.getForObject(uri+"/payment/lb",String.class);
        }
    }
}