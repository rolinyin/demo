package com.yonyou.demo.redis.service;

import com.yonyou.demo.redis.api.OrderServiceI;
import com.yonyou.demo.redis.entity.Order;
import com.yonyou.demo.redis.repository.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService implements OrderServiceI {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private OrderMapper mapper;

	public Order getById(String id){
		return mapper.getById(id);
	}

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
		if(StringUtils.isEmpty(record.getId())){
			//不规范，id越短越好
			record.setId(UUID.randomUUID().toString());
		}
		return mapper.insert(record);
	}

}
