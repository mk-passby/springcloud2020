package com.bli.guigu.springcloud.controller;

import com.bli.guigu.springcloud.service.IMessageProvider;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-08-08 20:50
 **/
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping(value = "sendMessage")
    public String sendMessage() {
        return iMessageProvider.send();
    }

}
