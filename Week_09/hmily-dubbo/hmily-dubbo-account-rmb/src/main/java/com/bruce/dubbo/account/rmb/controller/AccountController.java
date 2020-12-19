
package com.bruce.dubbo.account.rmb.controller;

import com.bruce.dubbo.account.rmb.service.PaymentService;
import com.bruce.dubbo.common.bo.AccountBO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bruce
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping(value = "/orderPay")
    @ApiOperation(value = "订单支付接口（注意这里模拟的是创建订单并进行支付扣减库存等操作）")
    public String orderPay(@RequestBody AccountBO bo) {
        final long start = System.currentTimeMillis();
        paymentService.makePayment(bo);
        System.out.println("消耗时间为:" + (System.currentTimeMillis() - start));
        return "";
    }

}
