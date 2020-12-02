package com.bruce.mysql.controller;

import com.bruce.mysql.model.User;
import com.bruce.mysql.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/addUser", method = {RequestMethod.POST})
    public String addUser(@RequestBody User user) {
        try {
            return userService.addUser(user) > 0 ? "添加用户成功" : "添加用户失败";
        }catch (Exception e) {
            log.error("-------------添加用户 失败: " + e + "-------------");
            return "添加用户失败";
        }
    }

    @RequestMapping(value = "/getList", method = {RequestMethod.POST})
    public List<User> getList() {
        try {
            return userService.getList();
        }catch (Exception e) {
            log.error("-------------获取用户列表 失败: " + e + "-------------");
            return null;
        }
    }

}
