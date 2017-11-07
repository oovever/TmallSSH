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

}
