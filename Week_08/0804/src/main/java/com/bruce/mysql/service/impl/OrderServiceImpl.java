package com.bruce.mysql.service.impl;

import com.bruce.mysql.mapper.OrderDao;
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
    private OrderDao orderDao;

    public int add(Long userId,Long orderId) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setUserId(userId);
        order.setActualAmount(1D);
        order.setTotalAmount(1D);
        order.setDiscountAmount(1D);
        order.setOrderStatus(0);
        order.setCreateDate(System.currentTimeMillis());
        order.setCreateBy(userId);
        order.setDelFlag(false);
        return orderDao.insert(order);
    }

    public int batchAdd(){
        List<Order> list = new ArrayList<Order>(100);
        Long m = System.currentTimeMillis();
        int result = 0;
        for (int i = 10; i < 100; i++) {

            Order order = new Order();
            order.setOrderId(Long.valueOf(i));
            order.setUserId(Long.valueOf(i));
            order.setActualAmount(Double.valueOf(i));
            order.setTotalAmount(Double.valueOf(i));
            order.setDiscountAmount(Double.valueOf(i));
            order.setOrderStatus(i%4);
            order.setCreateDate(m);
            order.setCreateBy(Long.valueOf(i));
            order.setDelFlag(false);
            list.add(order);
        }
        result = orderDao.batchInsert(list);

        Long end = System.currentTimeMillis();
        log.info("批量插入数据，花费时间为" + (end - m));
        return result;
    }

    public Order getByOrderId(Long orderId) {
        return orderDao.selectByPrimaryKey(orderId);
    }

    public List<Order> getList(Long userId,Long orderId) {
        List<Order> list = orderDao.getList(userId,orderId);
        return list;
    }

    public int deleteById(Long orderId) {
        return orderDao.deleteByPrimaryKey(orderId);
    }

    public int updateById(Long orderId, Long userId,Double totalAmount) {
        Order order = new Order();
        order.setOrderId(orderId);
        order.setTotalAmount(totalAmount);
        order.setDelFlag(true);
        order.setUpdateDate(System.currentTimeMillis());
        return orderDao.updateByPrimaryKeySelective(order);
    }
}
