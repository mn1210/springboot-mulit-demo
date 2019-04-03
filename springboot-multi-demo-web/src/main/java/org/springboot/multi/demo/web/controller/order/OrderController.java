package org.springboot.multi.demo.web.controller.order;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springboot.multi.demo.common.ResultEnum;
import org.springboot.multi.demo.model.order.Order;
import org.springboot.multi.demo.service.order.OrderService;
import org.springboot.multi.demo.web.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/addOrder/{id}",method=RequestMethod.GET)
//	@ResponseBody
	public String addOrder(@PathVariable("id") int id) throws Exception {
			Order order = new Order();
			order.setOrderId(id);
			order.setStatus("1");
			order.setUserId(1);
			orderService.add(order);
		return "ok";
		
	}
}
