package com.tmall.comparator;

import com.tmall.pojo.Product;

import java.util.Comparator;

/**
 * Created by OovEver on 2017/11/7.
 */
public class ProductAllComparator implements Comparator<Product> {
//    把 销量x评价 高的放前面
    @Override
    public int compare(Product p1, Product p2) {
        return p2.getReviewCount()*p2.getSaleCount()-p1.getReviewCount()*p1.getSaleCount();
    }
}
