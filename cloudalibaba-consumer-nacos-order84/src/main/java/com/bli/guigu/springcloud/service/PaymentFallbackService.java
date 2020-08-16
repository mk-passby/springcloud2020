package com.bli.guigu.springcloud.service;

import com.bli.guigu.springcloud.entities.CommonResult;
import com.bli.guigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-08-16 10:40
 **/
@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(44444, "服务降级返回,---PaymentFallbackService",
            new Payment(id, "errorSerial"));
    }
}
