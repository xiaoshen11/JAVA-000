package com.bruce.mysql.service;

import com.bruce.mysql.model.User;

import java.util.List;

public interface UserService {

    int addUser(User user);

    List<User> getList();
}
