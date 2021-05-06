package com.bjpowernode.dao;


import com.bjpowernode.pojo.Book;
import com.bjpowernode.pojo.Cart;
import com.bjpowernode.pojo.User;

import java.util.List;

public interface CartDao {
    int addItem(Cart cart);
    int updateItem(Cart cart);
    int deleteItem(Cart cart);
    int deleteAll(User user);
    Long queryCount(User user);
    List<Cart> queryItem(User user);
    Cart queryItemById(Integer id);
}
