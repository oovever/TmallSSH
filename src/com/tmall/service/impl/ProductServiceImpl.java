package com.tmall.service.impl;

import com.tmall.pojo.Category;
import com.tmall.pojo.OrderItem;
import com.tmall.pojo.Product;
import com.tmall.service.OrderItemService;
import com.tmall.service.ProductImageService;
import com.tmall.service.ProductService;
import com.tmall.service.ReviewService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by OovEver on 2017/11/6.
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {
    @Autowired
    ProductImageService productImageService;
    @Autowired
    OrderItemService    orderItemService;
    @Autowired
    ReviewService       reviewService;
//    1. 为分类填充产品集合
    @Override
    public void fill(List<Category> categorys) {
        for (Category category : categorys) {
            fill(category);
        }
    }
//2. 为多个分类填充产品集合
    @Override
    public void fill(Category category) {
        List<Product> products = listByParent(category);
        for (Product product : products) {
            productImageService.setFirstProdutImage(product);
        }
        category.setProducts(products);
    }
//3.为多个分类填充推荐产品集合，即把分类下的产品集合，按照8个为一行，拆成多行，以利于后续页面上进行显示
    @Override
    public void fillByRow(List<Category> categorys) {
        int productNumberEachRow = 8;
        for (Category category : categorys) {
            List<Product> products =  category.getProducts();
            List<List<Product>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                List<Product> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }

            category.setProductsByRow(productsByRow);
        }
    }

    @Override
    public void setSaleAndReviewNumber(Product product) {
        int saleCount = orderItemService.total(product);
        product.setSaleCount(saleCount);
        int reveiewCount = reviewService.total(product);
        product.setReviewCount(reveiewCount);

    }

    @Override
    public void setSaleAndReviewNumber(List<Product> products) {
        for (Product product : products) {
            setSaleAndReviewNumber(product);

        }
    }

    @Override
    public List<Product> search(String keyword, int start, int count) {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.add(Restrictions.like("name", "%" + keyword + "%"));
        return findByCriteria(dc, start, count);
    }
}
