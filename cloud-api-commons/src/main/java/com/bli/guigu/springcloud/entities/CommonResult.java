package com.bli.guigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: springcloud2020
 * @description: 返回结果
 * @author: mk_passby
 * @create: 2020-06-02 22:36
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private int code;
    private String message;
    private T data;

    public CommonResult(int code, String message) {
        this(code, message, null);
    }
}
