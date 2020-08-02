package com.bli.guigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-08-02 09:55
 **/
@Configuration
public class MySelfRuleConfig {

    @Bean
    public IRule myRule() {
        return new MySelfLoadBalancerRule();
    }
}
