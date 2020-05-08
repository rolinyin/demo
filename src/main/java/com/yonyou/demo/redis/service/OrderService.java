package com.yonyou.demo.redis.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.yonyou.demo.redis.api.OrderServiceI;
import com.yonyou.demo.redis.entity.Order;
import com.yonyou.demo.redis.repository.OrderMapper;

@Service
public class OrderService implements OrderServiceI {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrderMapper mapper;

	@Override
	@Cacheable(value = "redis-order", keyGenerator = "keyGenerator")
	public List<Order> getAllOrders() {
		logger.info(" ------------------获取所有order---------------");
		return mapper.getAllOrders();
	}

	@Override
	@CacheEvict(value = "redis-order", allEntries = true)
	public int insert(Order record) {
		logger.info(" ------------------插入order---------------");
		return mapper.insert(record);
	}

}
