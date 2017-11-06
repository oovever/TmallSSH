package com.tmall.service;

import com.tmall.pojo.User;

/**
 * Created by OovEver on 2017/11/6.
 */
public interface UserService extends BaseService {
    boolean isExist(String name);
    User get(String name, String password);
}
