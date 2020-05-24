package com.yonyou.demo.redis.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.ToString;

/**
 * 
 * @author 作者 yinyla@yonyou.com:
 * 
 * @version 创建时间：Apr 30, 2019 19:44:02 AM
 * 
 *          测试用例实体对象
 */
@Data
@ToString
public class Order implements Serializable {
	/**
	 * uid
	 */
	private static final long serialVersionUID = -7731722277060710055L;

	private String id;

	private Integer version;

	private String code;

	private String name;

	private Date creationtime;

	private String remark;
}