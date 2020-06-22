package com.bli.guigu.springcloud.controller;

import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-06-22 22:14
 **/
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/consul")
    public String paymentConsul() {
        return String.format("SpringCloud with consul:%s,UUID:%s", serverPort, UUID.randomUUID().toString());
    }
}
