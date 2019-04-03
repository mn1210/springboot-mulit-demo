package org.springboot.multi.demo.dao.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springboot.multi.demo.model.order.Order;



//@Mapper
public interface OrderDao {
	  
    void createIfNotExistsTable();
    
    void truncateTable();
    
    Long insert(Order model);
    
    void delete(Long orderId);
    
    void dropTable();
    
    List<Order> selectAll();
    
    Order selectOrderByOrderId(Long orderId);
}
