package com.bli.guigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-08-16 15:17
 **/
@Configuration
@MapperScan({"com.bli.guigu.springcloud.alibaba.dao"})
public class MyBatisConfig {

}
