package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : xiemogaminari
 * create at:  2020-05-27  15:19
 * @description: r
 */
@Configuration
public class MyLoadbalanceRule {
    //设置自己的RRibon负载均衡配置，RandomRule 随机
    @Bean
    public IRule MyRule(){
        return new RandomRule();
    }
}