package com.yonyou.demo.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 
 * @author 作者 yinyla@yonyou.com:
 * 
 * @version 创建时间：Apr 30, 2019 19:44:02 AM
 * 
 *          redis服务类
 */
@Component
public class RedisService {

	@Autowired
	private StringRedisTemplate redisTemplate;

	/**
	 * @Description 添加String类型的key-value
	 * @param name
	 * @param value
	 * @return
	 */
	public String setNameValue(String name, String value) {
		redisTemplate.opsForValue().set(name, value);
		return name;
	}

	/**
	 * @Description 获取String类型的value
	 * @param name
	 * @return
	 */
	public String findName(String name) {
		if (StringUtils.isEmpty(name)) {
			return null;
		}
		return redisTemplate.opsForValue().get(name);
	}

	/**
	 * @Description 根据key删除redis的数据
	 * @param name
	 * @return
	 */
	public String delNameValue(String name) {
		redisTemplate.delete(name);
		return name;
	}

	/**
	 * @Description redis事务性操作
	 * @param name
	 * @param value
	 * @return
	 */
	public Object multiTest(String name, String value) {
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.multi();
		redisTemplate.opsForValue().set(name, value);
		redisTemplate.delete(name);
		return redisTemplate.exec();
	}

	/**
	 * @Description 添加String类型的key-value 集合
	 * @param name
	 * @param values
	 * @return
	 */
	public String rightPushAll(String name, String... values) {
		redisTemplate.opsForList().rightPushAll(name, values);
		return name;
	}

	/**
	 * @Description 获取集合值
	 * @return
	 */
	public List<String> rangeAll() {

		return redisTemplate.opsForList().range("list", 0, -1);
	}

	/**
	 * 移除集合中右边的元素。
	 * 
	 * @param name
	 * @return
	 */
	public String rightPop(String name) {
		return redisTemplate.opsForList().rightPop(name);
	}
}
