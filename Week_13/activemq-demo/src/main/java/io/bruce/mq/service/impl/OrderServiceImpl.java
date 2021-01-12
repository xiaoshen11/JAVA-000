package io.bruce.mq.service.impl;

import com.alibaba.fastjson.JSON;
import io.bruce.mq.entity.Order;
import io.bruce.mq.mapper.OrderMapper;
import io.bruce.mq.service.OrderService;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void createOrder(Order order) {
        order.setStatus(0);
//        orderMapper.create(order);
        jmsMessagingTemplate.convertAndSend(new ActiveMQTopic(Order.ORDER_TOPIC), JSON.toJSONString(order));

    }
}
