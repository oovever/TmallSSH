package com.tmall.action;

import com.tmall.pojo.Category;

import java.util.List;

/**
 * Created by OovEver on 2017/11/5.
 * Action4Pojo用于提供实体对象以及实体对象集合的setter和getter.
 setter用于接收注入
 getter用于提供数据到JSP(VIEW)上
 */
public class Action4Pojo extends  Action4Pagination {
    protected Category category;

    protected List<Category> categorys;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }
}
