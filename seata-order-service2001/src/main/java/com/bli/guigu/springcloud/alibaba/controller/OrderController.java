package com.bli.guigu.springcloud.alibaba.controller;

import com.bli.guigu.springcloud.alibaba.domain.CommonResult;
import com.bli.guigu.springcloud.alibaba.domain.Order;
import com.bli.guigu.springcloud.alibaba.service.OrderService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-08-16 15:15
 **/
@RestController
public class OrderController{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}

