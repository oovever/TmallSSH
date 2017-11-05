package com.tmall.service;

import com.tmall.pojo.Category;
import com.tmall.util.Page;

import java.util.List;

/**
 * Created by OovEver on 2017/11/5.
 */
public interface PropertyService{
    public List listByCategory(Category category);
    public List list(Page page, Category category);
    public int total (Category category);
}
