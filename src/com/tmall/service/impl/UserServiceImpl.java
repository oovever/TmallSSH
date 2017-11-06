package com.tmall.service.impl;


import com.tmall.pojo.User;
import com.tmall.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by OovEver on 2017/11/6.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {
    @Override
    public boolean isExist(String name) {
        List l = list("name",name);
        if(!l.isEmpty())
            return true;
        return false;
    }

    @Override
    public User get(String name, String password) {
        List<User> l  = list("name",name, "password",password);
        if(l.isEmpty())
            return null;
        return l.get(0);
    }
}
