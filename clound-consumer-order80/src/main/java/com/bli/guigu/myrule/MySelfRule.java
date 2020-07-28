package com.bli.guigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-06-26 09:23
 **/
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        //随机
        return new RandomRule();
    }
}
