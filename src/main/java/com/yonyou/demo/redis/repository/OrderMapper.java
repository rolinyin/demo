package com.yonyou.demo.redis.repository;

import java.util.List;

import com.yonyou.demo.redis.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {


	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	Order getById(@Param("id") String id);

	/**
	 * 查询全部数据
	 * @return
	 */
	List<Order> getAllOrders();

	/**
	 * 新增
	 * @param record
	 * @return
	 */
	int insert(Order record);

}
