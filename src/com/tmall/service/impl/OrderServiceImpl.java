package com.tmall.service.impl;

import com.tmall.pojo.Order;
import com.tmall.pojo.OrderItem;
import com.tmall.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmall.service.OrderService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by OovEver on 2017/11/6.
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl implements OrderService{
    @Autowired
    OrderItemService orderItemService;
    @Override
//    事物
    @Transactional(propagation = Propagation.REQUIRED,rollbackForClassName = "Exception")
    public float createOrder(Order order, List<OrderItem> ois) {
        save(order);
        float total = 0;
        for (OrderItem oi : ois) {
            oi.setOrder(order);
            orderItemService.update(oi);
            total+=oi.getProduct().getPromotePrice()*oi.getNumber();
        }
        return total;
    }
}
