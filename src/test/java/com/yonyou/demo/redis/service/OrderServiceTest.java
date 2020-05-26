package com.yonyou.demo.redis.service;

import com.yonyou.demo.TestApplication;
import com.yonyou.demo.redis.api.OrderServiceI;
import com.yonyou.demo.redis.entity.Order;
import com.yonyou.demo.redis.entity.Product;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class OrderServiceTest {

	@Autowired
	private OrderServiceI service;

	private Order record;

	private String id;

	@BeforeClass
	public void setUp() {
		record = new Order();
		id = UUID.randomUUID().toString();
		record.setId(UUID.randomUUID().toString());
		record.setVersion(0);
		record.setCode("code001");
		record.setName("name001");
		record.setCreationtime(new Date());
	}

	@Test
	public void testInsert() {

		int result = service.insert(record);
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testGetById() {

		Order result = service.getById(id);

		System.out.println(result);
	}

	@Test
	public void testGetAllOrders() {
		List<Order> result = service.getAllOrders();
		result.forEach(System.out::println);
	}
}
