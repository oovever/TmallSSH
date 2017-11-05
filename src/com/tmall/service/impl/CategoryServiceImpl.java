package com.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmall.dao.impl.DAOImpl;
import com.tmall.pojo.Category;
import com.tmall.service.CategoryService;

import java.util.List;

/**
 * Created by OovEver on 2017/11/1.
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired  DAOImpl dao;
    @Override
    public List list() {
        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
        dc.addOrder(Order.desc("id"));
        return dao.findByCriteria(dc);
    }
}
