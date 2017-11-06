package com.tmall.service;

import com.tmall.pojo.Category;

import java.util.List;

/**
 * Created by OovEver on 2017/11/6.
 */
public interface ProductService extends BaseService {
    public void fill(List<Category> categorys);
    public void fill(Category category);
    public void fillByRow(List<Category> categorys);
}
