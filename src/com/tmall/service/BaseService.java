package com.tmall.service;

import com.tmall.util.Page;

import java.util.List;

/**
 * Created by OovEver on 2017/11/5.
 */
public interface BaseService {
    public Integer save(Object object);
    public void update(Object object);
    public void delete(Object object);

    public Object get(Class clazz, int id);
    public Object get(int id);

    public List list();
    public List listByPage(Page page);
    public int total();

}
