package io.bruce.mq.controller;

import io.bruce.mq.entity.Order;
import io.bruce.mq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("createOrder")
    public String createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return "success";
    }

}
