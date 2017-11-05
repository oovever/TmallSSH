package com.tmall.action;

import java.io.File;

/**
 * Created by OovEver on 2017/11/5.
 * Action4Service这个类就专门用于处理图片上传，其他的事情一概不管
 */
public class Action4Upload {
    protected File   img;
    protected String imgFileName;
    protected String imgContentType;

    public File getImg() {
        return img;
    }
    public void setImg(File img) {
        this.img = img;
    }
    public String getImgFileName() {
        return imgFileName;
    }
    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }
    public String getImgContentType() {
        return imgContentType;
    }
    public void setImgContentType(String imgContentType) {
        this.imgContentType = imgContentType;
    }
}
