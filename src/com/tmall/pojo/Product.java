package com.tmall.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by OovEver on 2017/11/6.
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @ManyToOne
//    @JoinColumn注释的是保存表与表之间关系的字段
    @JoinColumn(name = "cid")
    private Category category;
    private String   name;
    private String   subTitle;
    private float    originalPrice;
    private float    promotePrice;
    private int      stock;
    private Date     createDate;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSubTitle() {
        return subTitle;
    }
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
    public float getOriginalPrice() {
        return originalPrice;
    }
    public void setOriginalPrice(float originalPrice) {
        this.originalPrice = originalPrice;
    }
    public float getPromotePrice() {
        return promotePrice;
    }
    public void setPromotePrice(float promotePrice) {
        this.promotePrice = promotePrice;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


}
