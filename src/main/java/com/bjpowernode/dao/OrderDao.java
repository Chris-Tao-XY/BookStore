package com.bjpowernode.dao;


import com.alibaba.druid.sql.dialect.mysql.visitor.transform.OrderByResolve;
import com.bjpowernode.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {
    int createOrder(Order order);
    int addOrderItem(OrderItem orderItem);
    int updateStatues(Order order, @Param("newStatus") String newStatus);
    List<Cart> queryForBookByOrder(Order order);
    int queryOrderId();
    int cancelOrder(Order order);
    List<Order> queryOrderById(User user);
    List<Order> queryAllOrder();
}
