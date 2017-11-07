package com.tmall.comparator;

import com.tmall.pojo.Product;

import java.util.Comparator;

/**
 * Created by OovEver on 2017/11/7.
 * 销量比较器，销量高的放在前面
 */
public class ProductSaleCountComparator implements Comparator<Product> {
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getSaleCount()-p1.getSaleCount();
    }
}
