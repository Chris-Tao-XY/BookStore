package com.bjpowernode.service;

import com.bjpowernode.pojo.Cart;
import com.bjpowernode.pojo.User;

import java.math.BigDecimal;
import java.util.List;

public interface CartService {
    void addToCart(Cart cart);
    void deleteItemInCart(Cart cart);
    void changeItemInCart(Cart cart);
    void clear(User user);
    List<Cart> allItemInCart(User user);
    Integer countInCart(User user);
}
