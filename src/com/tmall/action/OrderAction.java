package com.tmall.action;

import com.tmall.service.OrderService;
import com.tmall.util.Page;
import org.apache.struts2.convention.annotation.Action;

import java.util.Date;

/**
 * Created by OovEver on 2017/11/6.
 */
public class OrderAction extends Action4Result{
    @Action("admin_order_list")
    public String list() {
        if (page == null)
            page = new Page();
        int total = orderService.total();
        page.setTotal(total);
        orders = orderService.listByPage(page);
        orderItemService.fill(orders);
        return "listOrder";
    }

    @Action("admin_order_delivery")
    public String delivery() {
        t2p(order);
        order.setDeliveryDate(new Date());
        order.setStatus(OrderService.waitConfirm);
        orderService.update(order);
        return "listOrderPage";
    }
}
