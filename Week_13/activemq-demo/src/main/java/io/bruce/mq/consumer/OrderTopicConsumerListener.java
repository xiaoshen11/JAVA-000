package io.bruce.mq.consumer;

import com.alibaba.fastjson.JSON;
import io.bruce.mq.entity.Order;
import io.bruce.mq.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class OrderTopicConsumerListener {

    @Autowired
    private OrderMapper orderMapper;

    @JmsListener(destination = Order.ORDER_TOPIC,containerFactory = "topicListener")
    public void readActiveQueue(String message) {
        System.out.println("topic接受到：" + message);
        Order order = JSON.parseObject(message,Order.class);
        order.setStatus(1);
        orderMapper.updateOrderStatus(order);
        System.out.println("handle order, order-id: " + order.getId());

    }

}
