package com.bjpowernode.controller;

import com.bjpowernode.eception.NotEnoughException;
import com.bjpowernode.pojo.Order;
import com.bjpowernode.pojo.User;
import com.bjpowernode.service.OrderService;

import org.apache.ibatis.annotations.ResultMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/order")
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("create")
    public Object createOrder(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        Map<String,Object> map=new HashMap<>();
        try {
            orderService.createOrder(user);
            map.put("status",1);
            map.put("success","生成订单成功,请注意收货");
        }catch (NotEnoughException enoughException){
            map.put("status",2);
            map.put("failed",enoughException.getMessage());
        }
        return map;
    }

    @RequestMapping("cancel")
    public Object cancelOrder() {
        return null;
    }

    @RequestMapping("display")
    public Object display(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        User user = (User) request.getSession().getAttribute("user");
        List<Order> orderList = orderService.queryForClient(user);
        map.put("orders", orderList);
        return map;
    }

}
