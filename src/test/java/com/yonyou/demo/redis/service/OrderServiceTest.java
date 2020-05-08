package com.yonyou.demo.redis.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yonyou.demo.TestApplication;
import com.yonyou.demo.redis.api.OrderServiceI;
import com.yonyou.demo.redis.entity.Order;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class OrderServiceTest {

	@Autowired
	private OrderServiceI service;

	@Test
	public void testInsert() {
		Order record = new Order();
		record.setId(UUID.randomUUID().toString());
		record.setVersion(0);
		record.setCode("code");
		record.setName("name");
		record.setCreationtime(new Date());
		int result = service.insert(record);
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testGetAllOrders() {
		List<Order> result1 = service.getAllOrders();
		List<Order> result2 = service.getAllOrders();
		Assert.assertEquals(result1, result2);
	}
}
