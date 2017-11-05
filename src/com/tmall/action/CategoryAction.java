package com.tmall.action;


/**
 * Created by OovEver on 2017/11/1.
 */


import com.tmall.util.Page;
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
    Page page;
    @Action("admin_category_list")
    public String list() {
        if (page == null) {
            page = new Page();
        }
        int total = categoryService.total();
        page.setTotal(total);
        categorys = categoryService.listByPage(page);
        return "listCategory";
    }

    public List<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(List<Category> categorys) {
        this.categorys = categorys;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}