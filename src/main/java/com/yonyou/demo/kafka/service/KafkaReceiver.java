package com.yonyou.demo.kafka.service;

import java.util.Optional;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

//@Component
public class KafkaReceiver {

	private static Logger logger = LoggerFactory.getLogger(KafkaReceiver.class);

	@KafkaListener(topics = { "mytopic" })
	public void listen(ConsumerRecord<?, ?> record) {
		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			logger.info("----------------- record =" + record);
			logger.info("------------------ message =" + message);
		}

	}

}