package com.tmall.service.impl;

import com.tmall.pojo.Order;
import com.tmall.pojo.OrderItem;
import com.tmall.service.OrderItemService;
import com.tmall.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by OovEver on 2017/11/6.
 */
@Service
public class OrderItemServiceImpl  extends BaseServiceImpl implements OrderItemService {
    @Autowired
    ProductImageService productImageService;
//    1. 为订单对象填充其orderItems字段，并且计算出订单总金额，订单总购买数量
    @Override
    public void fill(List<Order> orders) {
        for (Order order : orders)
            fill(order);
    }
// 为多个订单计算
    @Override
    public void fill(Order order) {
        List<OrderItem> orderItems = this.listByParent(order);
        order.setOrderItems(orderItems);
        float total = 0;
        int totalNumber = 0;
        for (OrderItem oi :orderItems) {
            total+=oi.getNumber()*oi.getProduct().getPromotePrice();
            totalNumber+=oi.getNumber();

            productImageService.setFirstProdutImage(oi.getProduct());
        }
        order.setTotal(total);
        order.setOrderItems(orderItems);
        order.setTotalNumber(totalNumber);
    }
}
