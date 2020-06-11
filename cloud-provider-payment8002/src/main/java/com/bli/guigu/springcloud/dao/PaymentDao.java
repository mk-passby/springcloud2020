package com.bli.guigu.springcloud.dao;

import com.bli.guigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-06-02 22:40
 **/
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment findById(@Param("id") Long id);

}
