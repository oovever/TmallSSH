package com.tmall.service;

import com.tmall.pojo.Order;

import java.util.List;

/**
 * Created by OovEver on 2017/11/6.
 */
public interface OrderItemService extends BaseService{
    public void fill(List<Order> orders);
    public void fill(Order order);
}
