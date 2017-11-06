package com.tmall.action;

import com.tmall.util.Page;
import org.apache.struts2.convention.annotation.Action;

/**
 * Created by OovEver on 2017/11/6.
 */
public class UserAction extends Action4Result {
    @Action("admin_user_list")
    public String list() {
        if(page==null)
            page = new Page();
        int total = userService.total();
        page.setTotal(total);
        users = userService.listByPage(page);
        return "listUser";
    }
}
