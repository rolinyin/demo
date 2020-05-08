package com.yonyou.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author 作者 yinyla@yonyou.com:
 * 
 * @version 创建时间：Apr 30, 2019 19:40:22 AM
 * 
 *          示例工程启动类
 */
@SpringBootApplication
@MapperScan({ "com.yonyou.demo.**.repository" })
@ComponentScan({ "com.yonyou" })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
