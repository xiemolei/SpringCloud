package com.springcloud.config;


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : xiemogaminari
 * create at:  2020-05-28  17:30
 * @description: a
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}