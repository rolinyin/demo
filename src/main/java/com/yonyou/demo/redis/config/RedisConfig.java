package com.yonyou.demo.redis.config;

import java.lang.reflect.Method;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author 作者 yinyla@yonyou.com:
 * 
 * @version 创建时间：Apr 30, 2019 19:44:02 AM
 * 
 *          缓存相关配置
 */
@Configuration
public class RedisConfig {

	@Bean
	public KeyGenerator keyGenerator() {
		return new KeyGenerator() {
			public Object generate(Object target, Method method,
					Object... params) {
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append("_").append(method.getName());
				for (Object obj : params) {
					if (obj == null)
						obj = "@null@";
					sb.append("_").append(obj.toString());
				}
				return sb.toString();
			}
		};
	}

	@Bean
	public RedisTemplate<String, String> redisTemplate(
			RedisConnectionFactory factory) {
		StringRedisTemplate template = new StringRedisTemplate(factory);
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(
				Object.class);
		ObjectMapper om = new ObjectMapper();
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.afterPropertiesSet();
		return template;
	}
}
