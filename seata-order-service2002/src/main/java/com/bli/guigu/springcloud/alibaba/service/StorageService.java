package com.bli.guigu.springcloud.alibaba.service;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-08-16 15:42
 **/
public interface StorageService {
    // 扣减库存
    void decrease(Long productId, Integer count);

}
