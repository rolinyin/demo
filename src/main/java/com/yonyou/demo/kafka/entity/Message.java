package com.yonyou.demo.kafka.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class Message implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2867480248670268122L;

	private String id;

	private Integer version;

	private String code;

	private String name;

	private Date creationtime;

	private String remark;
}