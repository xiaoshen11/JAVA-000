package com.bruce.mysql.controller;

import com.bruce.mysql.model.Order;
import com.bruce.mysql.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public String add(@RequestParam("userId") Long userId, @RequestParam("orderId")Long orderId) {
        try {
            return orderService.add( userId, orderId) > 0 ? "添加用户成功" : "添加用户失败";
        }catch (Exception e) {
            log.error("-------------添加用户 失败: " + e + "-------------");
            return "添加用户失败";
        }
    }

    @RequestMapping(value = "/batchAdd", method = {RequestMethod.POST})
    public String batchAdd() {
        try {
            return orderService.batchAdd() > 0 ? "添加用户成功" : "添加用户失败";
        }catch (Exception e) {
            log.error("-------------添加用户 失败: " + e + "-------------");
            return "添加用户失败";
        }
    }

    @RequestMapping(value = "/getByOrderId", method = {RequestMethod.GET})
    public Order getByOrderId(@RequestParam("orderId") Long orderId) {
        try {
            return orderService.getByOrderId( orderId);
        }catch (Exception e) {
            log.error("-------------getByOrderId 失败: " + e + "-------------");
            return null;
        }
    }

    @RequestMapping(value = "/getList", method = {RequestMethod.GET})
    public List<Order> getList(@RequestParam("userId") Long userId, @RequestParam("orderId")Long orderId) {
        try {
            return orderService.getList( userId, orderId);
        }catch (Exception e) {
            log.error("-------------getList 失败: " + e + "-------------");
            return null;
        }
    }

    @RequestMapping(value = "/deleteById", method = {RequestMethod.POST})
    public String deleteById( @RequestParam("orderId")Long orderId) {
        try {
            return orderService.deleteById( orderId) > 0 ? "删除用户成功" : "删除用户失败";
        }catch (Exception e) {
            log.error("-------------删除用户 失败: " + e + "-------------");
            return "删除用户失败";
        }
    }

    @RequestMapping(value = "/updateById", method = {RequestMethod.POST})
    public String updateById(@RequestParam("orderId") Long orderId, @RequestParam("updateUserId")Long userId,@RequestParam("totalAmount")Double totalAmount) {
        try {
            return orderService.updateById( orderId, userId,totalAmount) > 0 ? "更新用户成功" : "更新用户失败";
        }catch (Exception e) {
            log.error("-------------更新用户 失败: " + e + "-------------");
            return "更新用户失败";
        }
    }
}
