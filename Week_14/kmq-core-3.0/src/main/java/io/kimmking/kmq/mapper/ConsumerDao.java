package io.kimmking.kmq.mapper;


import io.kimmking.kmq.entity.Consumer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConsumerDao {
    int deleteByPrimaryKey(Long id);

    int insert(Consumer record);

    int insertSelective(Consumer record);

    Consumer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Consumer record);

    int updateByPrimaryKey(Consumer record);
}