package com.tmall.service.impl;


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
}
