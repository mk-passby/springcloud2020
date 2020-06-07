package com.bli.guigu.springcloud.entities;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springcloud2020
 * @description: 支付对象
 * @author: mk_passby
 * @create: 2020-06-02 22:31
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
