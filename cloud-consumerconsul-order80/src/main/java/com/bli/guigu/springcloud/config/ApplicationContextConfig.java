package com.bli.guigu.springcloud.config;

import javax.annotation.ManagedBean;
import javax.management.MXBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-06-22 22:26
 **/
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
