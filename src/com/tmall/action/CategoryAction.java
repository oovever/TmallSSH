package com.tmall.action;


/**
 * Created by OovEver on 2017/11/1.
 */


import com.tmall.util.ImageUtil;
import com.tmall.util.Page;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.tmall.pojo.Category;
import com.tmall.service.CategoryService;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Namespace("/")
@ParentPackage("basicstruts")
@Results(
        {
            /*分类管理*/
                @Result(name="listCategory", location="/admin/listCategory.jsp"),
                @Result(name="listCategoryPage", type = "redirect", location="/admin_category_list"),
        })
public class CategoryAction {

    @Autowired
    CategoryService categoryService;
    List<Category> categorys;
    Category category;
    File           img;

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }

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
    @Action("admin_category_add")
    public String add() {
        categoryService.save(category);
        File  imageFolder= new File(ServletActionContext.getServletContext().getRealPath("img/category"));
        File file = new File(imageFolder,category.getId()+".jpg");
        try {
            FileUtils.copyFile(img, file);
            BufferedImage img = ImageUtil.change2jpg(file);
            ImageIO.write(img, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "listCategoryPage";
    }
    @Action("admin_category_delete")
    public String  delete(){
        categoryService.delete(category);
        return "listCategoryPage";
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