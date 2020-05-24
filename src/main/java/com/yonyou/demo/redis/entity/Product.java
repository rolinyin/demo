package com.yonyou.demo.redis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品类
 */
@Data
public class Product implements Serializable {

    private String id;

    private Integer version;

    private String orderId;

    private String orderCode;

    private String orderName;

    private String code;

    private String name;

    private Date creationtime;

    private String remark;
}
