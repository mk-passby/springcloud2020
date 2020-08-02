package com.bli.guigu.springcloud.controller;

import com.bli.guigu.springcloud.entities.CommonResult;
import com.bli.guigu.springcloud.entities.Payment;
import com.bli.guigu.springcloud.service.PaymentService;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-06-02 23:04
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;


    @PostMapping("payment/create")
    public CommonResult createPayment(@RequestBody Payment payment) {
        log.info("创建payment----：{}", payment);
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(HttpStatus.OK.value(), "插入成功,serverPort:" + serverPort);
        } else {
            return new CommonResult(HttpStatus.BAD_REQUEST.value(),
                "插入失败,serverPort:" + serverPort);
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("查询id：{}", id);
        Payment payment = paymentService.findById(id);
        if (payment != null) {
            return new CommonResult<>(HttpStatus.OK.value(), "查询数据成功,serverPort:" + serverPort,
                payment);
        } else {
            return new CommonResult(HttpStatus.BAD_REQUEST.value(),
                "查询数据失败,serverPort:" + serverPort);
        }
    }

    @GetMapping(value = "payment/discovery")
    public Object discovery() {
        List<String> serviceList = discoveryClient.getServices();
        for (String service : serviceList) {
            log.info("********element:{}", service);
        }
        List<ServiceInstance> serviceInstanceList = discoveryClient
            .getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance : serviceInstanceList) {
            log.info(serviceInstance.getServiceId() + System.lineSeparator()
                + serviceInstance.getHost() + System.lineSeparator()
                + serviceInstance.getPort() + System.lineSeparator());
        }
        return this.discoveryClient;

    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return "servePort:" + serverPort;
    }
}
