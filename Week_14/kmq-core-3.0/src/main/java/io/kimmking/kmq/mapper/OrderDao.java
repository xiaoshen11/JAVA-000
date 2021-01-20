package io.kimmking.kmq.mapper;


import io.kimmking.kmq.entity.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order getOrder(String topic, int offset);
}