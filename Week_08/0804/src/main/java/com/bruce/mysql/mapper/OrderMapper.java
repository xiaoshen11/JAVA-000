package com.bruce.mysql.mapper;

import com.bruce.mysql.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author lw
 */
@Mapper
public interface OrderMapper {

    void insertOne(Order order);
    void insertMany(List<Order> orders);
    void delete(Long id);
    void update(Order order);
    List<Map<String, Object>> query(Map<String, Object> condition);
}
