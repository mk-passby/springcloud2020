package com.bli.guigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-08-02 20:44
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService:paymentInfo_OK--------------";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService:paymentInfo_TimeOut--------------";
    }
}
