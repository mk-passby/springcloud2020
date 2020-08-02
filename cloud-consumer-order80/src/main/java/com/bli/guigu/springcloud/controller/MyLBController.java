package com.bli.guigu.springcloud.controller;

import com.bli.guigu.springcloud.lb.LoadBalancer;
import java.net.URI;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-08-02 15:11
 **/
@RestController
public class MyLBController {
    @Resource
    private LoadBalancer loadBalancer;
    @Resource
    private RestTemplate restTemplate;
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 注意，测试该方法，需要注释掉@LoadBalanced
     * @return
     */
    @GetMapping(value = "/consumer/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance serviceInstance=loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}
