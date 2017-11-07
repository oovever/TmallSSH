package com.tmall.comparator;

import com.tmall.pojo.Product;

import java.util.Comparator;

/**
 * Created by OovEver on 2017/11/7.
 * 新品比较器，将创建日期晚的放在前面
 */
public class ProductDateComparator implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return p1.getCreateDate().compareTo(p2.getCreateDate());
    }
}
