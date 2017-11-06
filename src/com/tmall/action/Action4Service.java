package com.tmall.action;

import com.tmall.service.CategoryService;
import com.tmall.service.ProductService;
import com.tmall.service.PropertyService;
import org.apache.commons.lang.xwork.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Method;

/**
 * Created by OovEver on 2017/11/5.
 */
public class Action4Service extends Action4Pojo{
    @Autowired
    CategoryService categoryService;
    @Autowired
    PropertyService propertyService;
    @Autowired
    ProductService  productService;
    /**
     * transient to persistent
     * 瞬时对象转换为持久对象
     * @param o
     */
    public void t2p(Object o){
        try {
            Class clazz = o.getClass();
            int id = (Integer) clazz.getMethod("getId").invoke(o);
            Object persistentBean = categoryService.get(clazz, id);

            String beanName  = clazz.getSimpleName();
            Method setMethod = getClass().getMethod("set" + WordUtils.capitalize(beanName), clazz);
            setMethod.invoke(this, persistentBean);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
