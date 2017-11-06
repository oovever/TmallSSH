package com.tmall.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;

/**
 * Created by OovEver on 2017/11/6.
 */
public class ForeAction extends Action4Result{
    String msg;
    @Action("forehome")
    public String home() {
        categorys = categoryService.list();
        productService.fill(categorys);
        productService.fillByRow(categorys);
        return "home.jsp";
    }
    @Action("foreregister")
    public String register() {
//        对特殊字符进行转义
        user.setName(HtmlUtils.htmlEscape(user.getName()));
        boolean exist = userService.isExist(user.getName());

        if(exist){
            msg = "用户名已经被使用,不能使用";
            return "register.jsp";
        }
        userService.save(user);
        return "registerSuccessPage";
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
