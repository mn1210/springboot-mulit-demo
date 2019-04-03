package org.springboot.multi.demo.service.order.impl;

import java.sql.SQLIntegrityConstraintViolationException;


import org.springboot.multi.demo.common.ResultEnum;
import org.springboot.multi.demo.dao.order.OrderDao;
import org.springboot.multi.demo.dao.order.OrderItemDao;
import org.springboot.multi.demo.model.order.Order;
import org.springboot.multi.demo.model.order.OrderItem;
import org.springboot.multi.demo.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderItemDao orderItemDao;

	@Override
	public int add(Order order) throws Exception{
        orderDao.insert(order);
        OrderItem item = new OrderItem();
        item.setOrderId(order.getOrderId());
        item.setUserId(51);
        item.setStatus("INSERT_TEST");
        try {
			orderItemDao.insert(item);
		} catch (Exception e) {
		  System.out.println("==============="+e.getMessage());
//			throw new ApiException(ResultEnum.PRIMARY);
		}
		return 1;
	}

}
