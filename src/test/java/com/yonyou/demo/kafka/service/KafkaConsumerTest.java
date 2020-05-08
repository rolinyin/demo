package com.yonyou.demo.kafka.service;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yonyou.demo.TestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class KafkaConsumerTest {

	private String topicName = "mytopic";

	private ExecutorService executorService;

	private Properties props;

	@Before
	public void runBeforeTestMethod() {
		// Kafka consumer configuration settings
		props = new Properties();

		props.put("bootstrap.servers", "127.0.0.1:9092");
		props.put("group.id", "test-consumer-group");
		props.put("enable.auto.commit", "true");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", StringDeserializer.class.getName());
		props.put("value.deserializer", StringDeserializer.class.getName());
		executorService = Executors.newFixedThreadPool(5);
	}

	@Test
	public void testConsume() {

		// print the topic name
		System.out.println("Subscribed to topic " + topicName);
		final AtomicInteger atomicInt = new AtomicInteger(0);
		for (int i = 0; i < 5; i++) {
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(
							props);
					consumer.subscribe(Arrays.asList(topicName));
					int index = atomicInt.incrementAndGet();
					while (true) {

						ConsumerRecords<String, String> records = consumer
								.poll(100);
						for (ConsumerRecord<String, String> record : records)

							System.out
									.printf("index = %d,offset = %d, key = %s, value = %s\n",
											index, record.offset(),
											record.key(), record.value());
					}
				}

			});
		}

		LockSupport.park();
	}
}
