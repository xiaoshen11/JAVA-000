package com.bruce.mysql.service.impl;

import com.bruce.mysql.mapper.OrderDao;
import com.bruce.mysql.mapper.UserDao;
import com.bruce.mysql.model.Order;
import com.bruce.mysql.model.User;
import com.bruce.mysql.service.OrderService;
import com.bruce.mysql.service.UserService;
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

    public int batchAdd() {
        //测试添加100w数据
        List<Order> list = new ArrayList<Order>(10000);
        Long m = System.currentTimeMillis();
        int result = 0;
        for (int j = 0; j < 1000; j++) {

            for (int i = 0; i < 1000; i++) {
                Order order = new Order();
                order.setUserId(Long.valueOf(i));
                order.setActualAmount(Double.valueOf(i));
                order.setTotalAmount(Double.valueOf(i));
                order.setDiscountAmount(Double.valueOf(i));
                order.setOrderStatus(i/4);
                order.setCreateDate(m);
                order.setCreateBy(Long.valueOf(i));
                order.setDelFlag(false);
                list.add(order);
            }
            result += orderDao.batchInsert(list);
            list.clear();
        }
        Long end = System.currentTimeMillis();
        log.info("批量插入数据，花费时间为" + (end - m));
        return result;
    }
}
