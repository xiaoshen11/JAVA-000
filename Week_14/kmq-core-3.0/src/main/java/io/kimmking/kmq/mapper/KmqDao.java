package io.kimmking.kmq.mapper;


import io.kimmking.kmq.entity.Kmq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface KmqDao {
    int deleteByPrimaryKey(Long id);

    int insert(Kmq record);

    int insertSelective(Kmq record);

    Kmq selectByPrimaryKey(Long id);

    Kmq selectByTopic(String topic);

    int updateByPrimaryKeySelective(Kmq record);

    int updateByPrimaryKey(Kmq record);
}