package com.yonyou.demo.redis.service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yonyou.demo.TestApplication;

/**
 * @author 作者 yinyla@yonyou.com:
 * 
 * @version 创建时间：Apr 30, 2019 19:44:02 AM
 * 
 *          redis测试类
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class RedisServiceTest {

	final String RDS_NAME = "key";
	final String VALUE = "val";

	@Autowired
	private RedisService redisService;

	@After
	public void runAfterTestMethod() {
		redisService.delNameValue(RDS_NAME);
	}

	@Test
	public void testSetGetValue() {

		redisService.setNameValue(RDS_NAME, VALUE);
		Assert.assertEquals(VALUE, redisService.findName(RDS_NAME));
	}

	@Test
	public void testMultiExec() {
		redisService.multiTest(RDS_NAME, VALUE);
		Assert.assertNull(redisService.findName(RDS_NAME));
	}

	@Test
	public void testListExec() {
		String[] values = { "a", "b", "c", "d", "e", "f", "g" };
		redisService.rightPushAll(RDS_NAME, values);
		Assert.assertEquals("g", redisService.rightPop(RDS_NAME));
	}
}
