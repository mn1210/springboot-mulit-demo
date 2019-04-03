package org.springboot.multi.demo.dao.order;

import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.springboot.multi.demo.model.order.OrderItem;

//@Mapper
public interface OrderItemDao {
	void createIfNotExistsTable();

	void truncateTable();

	Long insert(OrderItem model);

	void delete(Long orderItemId);

	void dropTable();

	List<OrderItem> selectAll();
}
