package com.bruce.mysql.service.impl;

import com.bruce.mysql.mapper.master.UserWriteDao;
import com.bruce.mysql.mapper.slave.UserReadDao;
import com.bruce.mysql.model.User;
import com.bruce.mysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserWriteDao userWriteDao;
    @Autowired
    private UserReadDao userReadDao;

    public int addUser(User user) {
        Long m = System.currentTimeMillis();
        user.setCreateDate(m);
        user.setDelFlag(false);

        return userWriteDao.insert(user);
    }

    public List<User> getList() {
        return userReadDao.getList();
    }
}
