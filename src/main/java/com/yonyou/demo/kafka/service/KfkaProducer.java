package com.yonyou.demo.kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yonyou.demo.kafka.entity.Message;

@Component
@Scope("prototype")
public class KfkaProducer {

	private static Logger logger = LoggerFactory.getLogger(KfkaProducer.class);

	private Gson gson = new GsonBuilder().create();

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	// 发送消息方法
	public void send(Message message) {
		logger.info("发送消息 ----->>>>>  message = {}", gson.toJson(message));
		kafkaTemplate.send("mytopic", gson.toJson(message));
	}

}