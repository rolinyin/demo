package com.yonyou.demo.kafka.service;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import com.yonyou.demo.TestApplication;
import com.yonyou.demo.kafka.entity.Message;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class KafkaProducerTest extends AbstractJUnit4SpringContextTests {

	private Message message;

	private ExecutorService executorService;

	@Before
	public void runBeforeTestMethod() {
		message = new Message();
		message.setVersion(0);
		message.setCreationtime(new Date());
		executorService = Executors.newFixedThreadPool(5);

	}

	@Test
	public void testSend() {
		CountDownLatch latch = new CountDownLatch(5);
		for (int i = 0; i < 5; i++) {
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					message.setId(UUID.randomUUID().toString());
					KfkaProducer producer = applicationContext
							.getBean(KfkaProducer.class);
					System.out.println(producer + "--------------------");
					producer.send(message);
					latch.countDown();
				}

			});
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
