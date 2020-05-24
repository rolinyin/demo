package com.yonyou.demo.redis.api;

import com.yonyou.demo.redis.entity.Order;

import java.util.List;

/**
 * 
 * @author 作者 yinyla@yonyou.com:
 * 
 * @version 创建时间：Apr 30, 2019 19:44:02 AM
 * 
 *          测试用例服务类
 */
public interface OrderServiceI {

	/**
	 * 根据主键查询
	 * @param id
	 * @return
	 */
	Order getById(String id);

	/**
	 * 查询全部数据
	 * @return
	 */
	List<Order> getAllOrders();

	/**
	 * 新增数据
	 * @param record
	 * @return
	 */
	int insert(Order record);
}
