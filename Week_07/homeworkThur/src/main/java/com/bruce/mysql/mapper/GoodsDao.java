package com.bruce.mysql.mapper;

import com.bruce.mysql.model.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsDao {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
}