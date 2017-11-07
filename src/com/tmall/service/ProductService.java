package com.tmall.service;

import com.tmall.pojo.Category;
import com.tmall.pojo.Product;

import java.util.List;

/**
 * Created by OovEver on 2017/11/6.
 */
public interface ProductService extends BaseService {
    public void fill(List<Category> categorys);
    public void fill(Category category);
    public void fillByRow(List<Category> categorys);
    public void setSaleAndReviewNumber(Product product);
    public void setSaleAndReviewNumber(List<Product> products);

    public List<Product> search(String keyword, int start, int count);
}
