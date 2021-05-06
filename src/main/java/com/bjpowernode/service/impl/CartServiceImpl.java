package com.bjpowernode.service.impl;

import com.bjpowernode.dao.CartDao;
import com.bjpowernode.pojo.Cart;
import com.bjpowernode.pojo.User;
import com.bjpowernode.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public void changeItemInCart(Cart cart) {
        cartDao.updateItem(cart);
    }

    @Override
    public void addToCart(Cart cart) {
        Cart cart1 = cartDao.queryItemById(cart.getBookId());
        if(cart1==null){
            cartDao.addItem(cart);
        }else {
            Cart cart2=new Cart();
            cart2.setUserId(cart1.getUserId());
            cart2.setBookId(cart1.getBookId());
            cart2.setCount(cart1.getCount()+cart.getCount());
            cartDao.updateItem(cart2);
        }
    }

    @Override
    public void deleteItemInCart(Cart cart) {
        cartDao.deleteItem(cart);
    }

    @Override
    public void clear(User user) {
        cartDao.deleteAll(user);
    }

    @Override
    public List<Cart> allItemInCart(User user) {
        return cartDao.queryItem(user);
    }

    @Override
    public Integer countInCart(User user) {
        return Math.toIntExact(cartDao.queryCount(user));
    }
}
