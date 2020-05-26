package com.yonyou.demo.redis.controller;

import com.yonyou.demo.redis.api.OrderServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：yuelin.yin@rootcloud.com
 * @date ：Created in 2020/5/25 21:35
 * @description：controller
 * @modified By：
 */

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderServiceI service;

    @GetMapping(value = "/orders")
    public Object getAllOrders(){

        return service.getAllOrders();
    }
}
