package com.tmall.action;

import org.apache.struts2.ServletActionContext;

/**
 * Created by OovEver on 2017/11/6.
 */
public class Action4Parameter extends Action4Service {
    //错误消息
    protected String msg;
    //分类页面的排序变量
    protected String sort;

    //当前所处于的web应用名称，如果按照教程来
    protected String contextPath;
    //搜索关键字
    protected String keyword;
    //购物数量
    protected int num;

    //立即购买生成的订单项id
    protected int oiid;
    //通过购物车选中的多个订单项id
    protected int[] oiids;
    public Action4Parameter(){
        contextPath = ServletActionContext.getServletContext().getContextPath();
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
    public String getKeyword() {
        return keyword;
    }


    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public int getNum() {
        return num;
    }


    public void setNum(int num) {
        this.num = num;
    }
    public int getOiid() {
        return oiid;
    }


    public void setOiid(int oiid) {
        this.oiid = oiid;
    }
    public int[] getOiids() {
        return oiids;
    }


    public void setOiids(int[] oiids) {
        this.oiids = oiids;
    }

}
