package com.tmall.action;

import com.tmall.util.Page;

/**
 * Created by OovEver on 2017/11/5.
 * Action4Pagination 专门用于处理分页，并且继承上传专用 Action4Upload，这样就能又处理分页，又处理上传
 */
public class Action4Pagination extends Action4Upload {
    protected Page page;
    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
