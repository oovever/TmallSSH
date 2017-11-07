package com.tmall.comparator;

import com.tmall.pojo.Product;

import java.util.Comparator;

/**
 * Created by OovEver on 2017/11/7.
 * 价格比较器，价格低的放在前面
 */
public class ProductPriceComparator implements Comparator<Product>{

    @Override
    public int compare(Product p1, Product p2) {
        return (int) (p1.getPromotePrice() - p2.getPromotePrice());
    }
}
