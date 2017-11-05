package com.tmall.action;


/**
 * Created by OovEver on 2017/11/1.
 */


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmall.pojo.Category;
import com.tmall.service.CategoryService;

import java.util.List;

@Namespace("/")
@ParentPackage("basicstruts")
@Results(
        {
            /*分类管理*/
                @Result(name="listCategory", location="/admin/listCategory.jsp"),
        })
public class CategoryAction {

    @Autowired
    CategoryService categoryService;

    List<Category> categorys;

    @Action("admin_category_list")
    public String list() {
        categorys = categoryService.list();
        System.out.println(categorys);
        return "listCategory";
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }

}