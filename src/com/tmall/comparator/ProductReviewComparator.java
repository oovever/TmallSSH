package com.tmall.comparator;

import com.tmall.pojo.Product;

import java.util.Comparator;

/**
 * Created by OovEver on 2017/11/7.
 * 人气比较器 把 评价数量多的放前面
 */
public class ProductReviewComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getReviewCount()-p1.getReviewCount();
    }
}
