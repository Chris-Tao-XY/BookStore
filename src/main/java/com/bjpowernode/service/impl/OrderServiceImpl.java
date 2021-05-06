package com.bjpowernode.service.impl;

import com.bjpowernode.dao.BookDao;
import com.bjpowernode.dao.CartDao;
import com.bjpowernode.dao.OrderDao;
import com.bjpowernode.eception.NotEnoughException;
import com.bjpowernode.pojo.*;
import com.bjpowernode.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private BookDao bookDao;

    @Override
    public void sendOrder(Order order, String newStatus) {
        orderDao.updateStatues(order,newStatus);
    }

    @Transactional
    @Override
    public void createOrder(User user) {
        Order order=new Order();
        order.setStatus("已生成订单");
        order.setUserId(user.getId());
        List<Cart> cartList = cartDao.queryItem(user);
        orderDao.createOrder(order);
        int orderId = orderDao.queryOrderId();
        for(Cart cart:cartList){
            Book book=bookDao.queryBookById(cart.getBookId());
            if(book.getStock()<cart.getCount()){
                throw new NotEnoughException(book.getName()+"库存不够,请减少数量购买,或等待店家补货");
            }
            book.setSales(book.getSales()+cart.getCount());
            book.setStock(book.getStock()-cart.getCount());
            bookDao.updateBook(book);
            OrderItem item=new OrderItem();
            item.setBookId(book.getId());
            item.setCount(cart.getCount());
            item.setOrderId(orderId);
            item.setPrice(book.getPrice().multiply(new BigDecimal(cart.getCount())));
            orderDao.addOrderItem(item);
        }
        cartDao.deleteAll(user);
    }
    @Transactional
    @Override
    public void cancelOrder(Order order) {
        orderDao.updateStatues(order,"已取消订单");
        List<Cart> bookList = orderDao.queryForBookByOrder(order);
        for(Cart cart:bookList){
            Book book=bookDao.queryBookById(cart.getBookId());
            book.setSales(book.getSales()-cart.getCount());
            book.setStock(book.getStock()+cart.getCount());
            bookDao.updateBook(book);
        }
        orderDao.cancelOrder(order);
    }

    @Override
    public List<Order> queryForClient(User user) {
        return orderDao.queryOrderById(user);
    }

    @Override
    public List<Order> queryForManager() {
        return orderDao.queryAllOrder();
    }
}
