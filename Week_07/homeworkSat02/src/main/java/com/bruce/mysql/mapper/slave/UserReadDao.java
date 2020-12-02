package com.bruce.mysql.mapper.slave;

import com.bruce.mysql.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserReadDao {

    User selectByPrimaryKey(Long id);

    List<User> getList();
}