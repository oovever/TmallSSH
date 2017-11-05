package com.tmall.service;

import com.tmall.pojo.Category;
import com.tmall.util.Page;

import java.util.List;

/**
 * Created by OovEver on 2017/11/1.
 */
public interface CategoryService {
    public List list();
    public int total();
    public void save(Category category);
    public List<Category> listByPage(Page page);
    public void delete(Category category);
    public Category get(Class clazz, int id);
    public void update(Category category);
}
