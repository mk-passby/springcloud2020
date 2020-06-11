package com.bli.guigu.springcloud.service;

import com.bli.guigu.springcloud.entities.Payment;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-06-02 22:54
 **/
public interface PaymentService {
    public int create(Payment payment);

    public Payment findById(Long id);
}
