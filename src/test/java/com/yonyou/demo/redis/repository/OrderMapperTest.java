package com.yonyou.demo.redis.repository;

import com.yonyou.demo.TestApplication;
import com.yonyou.demo.redis.entity.Order;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @RunWith 注解作用：
 * 	1.一个运行器
 *	2.JUnit运行使用Spring的测试支持
 *
 * @SpringBootTest 注解作用：
 * 	1.当前类为springboot的测试类
 * 	2.加载springboot启动类，启动springboot
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class OrderMapperTest {

	@Autowired
	private OrderMapper mapper;

	private Order record;

	private String id;

	/**
     * @Before：在跑测试test001，test002时候都会各执行一次@Before部分的代码。
	 *
	 * @Beforeclass： 在类中只会被执行一次
	 *
	 * @After：释放资源 对于每一个测试方法都要执行一次
	 *
	 * @Afterclass:所有测试用例执行完才执行一次
	 */
	@BeforeClass
	public void setUp() {
		record = new Order();
		id = UUID.randomUUID().toString();
		record.setId(UUID.randomUUID().toString());
		record.setVersion(0);
		record.setCode("code");
		record.setName("name");
		record.setCreationtime(new Date());
	}

	@Test
	public void testInsert() {

		int result = mapper.insert(record);
		Assert.assertTrue(result == 1);
	}

	@Test
	public void testGetById() {
		Order result = mapper.getById(id);
		System.out.println(record.toString());
		System.out.println(result.toString());
		Assert.assertSame(record.toString(), result.toString());
	}

	@Test
	public void testGetAllOrders() {
		List<Order> result = mapper.getAllOrders();
		result.forEach(System.out::println);
	}
}
