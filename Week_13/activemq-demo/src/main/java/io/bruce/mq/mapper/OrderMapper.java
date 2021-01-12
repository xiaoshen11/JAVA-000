package io.bruce.mq.mapper;

import io.bruce.mq.entity.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapper {

    /**
     * 获取未处理的订单列表
     * @return
     */
    List<Order> getUnHandleOrder();

    /**
     * 修改订单状态
     * @param order
     * @return
     */
    int updateOrderStatus(Order order);

    void create(Order order);
}
