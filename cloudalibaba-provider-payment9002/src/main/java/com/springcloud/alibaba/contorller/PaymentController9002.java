package com.springcloud.alibaba.contorller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : xiemogaminari
 * create at:  2020-07-05  21:14
 * @description:
 */
@RestController
public class PaymentController9002 {
        @Value("${server.port}")
        private String serverPort;

        @GetMapping(value = "/payment/nacos/{id}")
        public String getPayment(@PathVariable("id") Integer id)
        {
            return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
        }
}