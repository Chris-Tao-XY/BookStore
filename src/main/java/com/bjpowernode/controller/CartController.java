package com.bjpowernode.controller;


import com.bjpowernode.pojo.Cart;
import com.bjpowernode.pojo.User;
import com.bjpowernode.service.CartService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/cart")
@RestController
public class CartController {
    @Resource
    private CartService cartService;

    @RequestMapping("/addInCart")
    public Object addInCart(@RequestBody Cart cart, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Object ObjectUser = request.getSession().getAttribute("user");
        if (ObjectUser != null) {
            User user = ((User) ObjectUser);
            cart.setUserId(user.getId());
            cartService.addToCart(cart);
            Integer countInCart = cartService.countInCart(user);
            map.put("countInCart", "您购物车里有" + countInCart + "件商品");
            map.put("status", 1);
            map.put("success", "您刚刚将<<" + cart.getBookname() + ">>放入购物车");
        } else {
            map.put("status", 2);
            map.put("failed", "还未登陆,请登录使用购物车");
            map.put("url", request.getContextPath() + "/staticResource/pages/user/login.html");
        }
        return map;
    }

    @RequestMapping("/countInCart")
    public Object countInCart(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Object ObjectUser = request.getSession().getAttribute("user");
        if (ObjectUser != null) {
            User user = ((User) ObjectUser);
            Integer countInCart = cartService.countInCart(user);
            map.put("status", 1);
            map.put("countInCart", "您购物车里有" + countInCart + "件商品");
            map.put("user", user);
        } else {
            map.put("status", 2);
        }
        return map;
    }

    @RequestMapping("/displayInCart")
    public Object display(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Object ObjectUser = request.getSession().getAttribute("user");
        if (ObjectUser != null) {
            User user = ((User) ObjectUser);
            List<Cart> cartItems = cartService.allItemInCart(user);
            map.put("status", 1);
            map.put("AllItemsInCart", cartItems);
            map.put("user", user);
        } else {
            map.put("status", 2);
            map.put("failed", "请登录使用购物车");
            map.put("url", request.getContextPath() + "/staticResource/pages/user/login.html");
        }
        return map;
    }

    @RequestMapping("/updateCount")
    public Object updateCount(HttpServletRequest request,@RequestBody Cart cart) {
        Map<String, Object> map = new HashMap<>();
        Object ObjectUser = request.getSession().getAttribute("user");
        if (ObjectUser != null) {
            User user = ((User) ObjectUser);
            cart.setUserId(user.getId());
            cartService.changeItemInCart(cart);
            map.put("status", 1);
            map.put("success", cart.getBookname()+"的数量修改成功");
            map.put("user", user);
        } else {
            map.put("status", 2);
            map.put("failed", "请登录使用购物车");
            map.put("url", request.getContextPath() + "/staticResource/pages/user/login.html");
        }
        return map;
    }

    @RequestMapping("/deleteCart")
    public Object deleteCart(HttpServletRequest request,@RequestBody Cart cart) {
        Map<String, Object> map = new HashMap<>();
        Object ObjectUser = request.getSession().getAttribute("user");
        if (ObjectUser != null) {
            User user = ((User) ObjectUser);
            cart.setUserId(user.getId());
            cartService.deleteItemInCart(cart);
            map.put("status", 1);
            map.put("success", cart.getBookname()+"移出成功");
            map.put("user", user);
        } else {
            map.put("status", 2);
            map.put("failed", "请登录使用购物车");
            map.put("url", request.getContextPath() + "/staticResource/pages/user/login.html");
        }
        return map;
    }

    @RequestMapping("/clear")
    public Object clear(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        Object ObjectUser = request.getSession().getAttribute("user");
        if (ObjectUser != null) {
            User user = ((User) ObjectUser);
            cartService.clear(user);
            map.put("status", 1);
            map.put("success", "购物车清空成功");
            map.put("user", user);
        } else {
            map.put("status", 2);
            map.put("failed", "请登录使用购物车");
            map.put("url", request.getContextPath() + "/staticResource/pages/user/login.html");
        }
        return map;
    }
}
