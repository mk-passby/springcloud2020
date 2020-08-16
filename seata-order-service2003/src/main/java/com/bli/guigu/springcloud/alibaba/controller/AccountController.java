package com.bli.guigu.springcloud.alibaba.controller;

import com.bli.guigu.springcloud.alibaba.domain.CommonResult;
import com.bli.guigu.springcloud.alibaba.service.AccountService;
import java.math.BigDecimal;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud2020
 * @description:
 * @author: mk_passby
 * @create: 2020-08-16 15:59
 **/
@RestController
@Slf4j
public class AccountController {

    @Resource
    AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId,
        @RequestParam("money") BigDecimal money) {
        log.info("userid is {}，money is {}", userId, money);
        accountService.decrease(userId, money);
        return new CommonResult(200, "扣减账户余额成功！");
    }
}

