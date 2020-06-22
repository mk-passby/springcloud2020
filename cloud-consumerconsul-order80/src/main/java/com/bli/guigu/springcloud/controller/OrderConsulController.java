package com.bli.guigu.springcloud.controller;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-06-22 22:27
 **/
@RestController
public class OrderConsulController {

    private static final String INVOME_URL = "http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String getPayment() {
        return restTemplate.getForObject(INVOME_URL + "/payment/consul", String.class);
    }
}
