package com.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : xiemogaminari
 * create at:  2020-07-05  22:52
 * @description:
 */
@RefreshScope
@RestController
public class ConfigClientController {
    @Value("${config.info}")
    String ConfigInfo;

    @GetMapping("/configInfo")
    public String GetConfigInfo(){
        return ConfigInfo;
    }
}