package com.tmall.service;

import com.tmall.pojo.Product;
import com.tmall.pojo.ProductImage;

import java.util.List;

/**
 * Created by OovEver on 2017/11/6.
 */
public interface ProductImageService extends BaseService {
//    图片类型
    public static final String type_single = "type_single";
    public static final String type_detail = "type_detail";
//    图片处理
public List<ProductImage> list(String key_product, Product product, String key_type, String type) ;
    public void setFirstProdutImage(Product product);
}
