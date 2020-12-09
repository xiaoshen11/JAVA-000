package com.bruce.mysql.service.impl;

import com.bruce.mysql.mapper.OrderMapper;
import com.bruce.mysql.model.Order;
import com.bruce.mysql.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderDao;

    public int add() {

        Order order = new Order(1L,1L);
        orderDao.insertOne(order);
        return 1;
    }
}
