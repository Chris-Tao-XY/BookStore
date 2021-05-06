package com.bjpowernode.service;

import com.bjpowernode.pojo.Cart;
import com.bjpowernode.pojo.Order;
import com.bjpowernode.pojo.User;

import java.util.List;

public interface OrderService {
    void sendOrder(Order order,String newStatus);
    void createOrder(User user);
    void cancelOrder(Order order);
    List<Order> queryForClient(User user);
    List<Order> queryForManager();
}
