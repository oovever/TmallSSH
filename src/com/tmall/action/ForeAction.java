package com.tmall.action;

/**
 * Created by OovEver on 2017/11/6.
 */
public class ForeAction extends Action4Result{
    public String home() {
        categorys = categoryService.list();
        productService.fill(categorys);
        productService.fillByRow(categorys);
        return "home.jsp";
    }
}
