package com.bruce.mysql.service;

import com.bruce.mysql.model.Order;

import java.util.List;

public interface OrderService {

    int add(Long userId,Long orderId);

    int batchAdd();

    Order getByOrderId(Long orderId);

    List<Order> getList(Long userId, Long orderId);

    int deleteById(Long orderId);

    int updateById(Long orderId,Long userId,Double totalAmount);

}
