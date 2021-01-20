package io.kimmking.kmq.controller;

import io.kimmking.kmq.entity.Consumer;
import io.kimmking.kmq.entity.Order;
import io.kimmking.kmq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/consumerOrder")
    public String consumerOrder(@RequestBody Consumer consumer, @RequestParam("topic") String topic) {
        try {
            orderService.consumerOrder(consumer,topic);
            return "success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @PostMapping("/producerOrder")
    public String producerOrder(@RequestParam("topic")String topic, @RequestBody Order order) {
        try {
            orderService.producerOrder(topic, order);
            return "success";
        }catch (Exception e){
            return e.getMessage();
        }
    }

}
