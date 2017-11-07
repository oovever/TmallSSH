package com.tmall.service;

import com.tmall.pojo.Order;
import com.tmall.pojo.Review;

/**
 * Created by OovEver on 2017/11/7.
 */
public interface ReviewService extends BaseService {
    void saveReviewAndUpdateOrderStatus(Review review, Order order);
}
