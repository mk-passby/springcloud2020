package com.bli.guigu.springcloud.controller;

import com.bli.guigu.springcloud.entities.CommonResult;
import com.bli.guigu.springcloud.entities.Payment;
import com.bli.guigu.springcloud.service.PaymentService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("payment/create")
    public CommonResult createPayment(Payment payment) {
        log.info("创建payment----：{}", payment);
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult(HttpStatus.OK.value(), "插入成功");
        } else {
            return new CommonResult(HttpStatus.BAD_REQUEST.value(), "插入失败");
        }
    }

    @GetMapping(value = "payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        log.info("查询id");
        Payment payment = paymentService.findById(id);
        return new CommonResult<>(HttpStatus.OK.value(), "查询数据库成功", payment);
    }
}
