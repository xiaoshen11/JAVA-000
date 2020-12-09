package com.bruce.mysql.controller;

import com.bruce.mysql.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/batchAdd", method = {RequestMethod.POST})
    public String batchAdd() {
        try {
            return orderService.add() > 0 ? "添加用户成功" : "添加用户失败";
        }catch (Exception e) {
            log.error("-------------添加用户 失败: " + e + "-------------");
            return "添加用户失败";
        }
    }

}
