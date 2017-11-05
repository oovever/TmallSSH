package com.tmall.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 * Created by OovEver on 2017/11/5.
 */
@Namespace("/")
@ParentPackage("basicstruts")
@Results(
        {
            /*分类管理*/
                @Result(name="listCategory", location="/admin/listCategory.jsp"),
                @Result(name="editCategory", location="/admin/editCategory.jsp"),
                @Result(name="listCategoryPage", type = "redirect", location="/admin_category_list"),
        })
public class Action4Result extends Action4Service{
}
