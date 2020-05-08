package com.yonyou.demo.redis.repository;

import java.util.List;

import com.yonyou.demo.redis.entity.Order;

public interface OrderMapper {

	List<Order> getAllOrders();

	int insert(Order record);
}
