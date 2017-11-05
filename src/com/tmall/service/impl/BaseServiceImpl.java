package com.tmall.service.impl;

import com.tmall.dao.impl.DAOImpl;
import com.tmall.pojo.Category;
import com.tmall.service.BaseService;
import com.tmall.util.Page;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by OovEver on 2017/11/5.
 */
@Service
public class BaseServiceImpl  extends ServiceDelegateDAO implements BaseService {

    protected Class clazz;

    public BaseServiceImpl(){
        try{
            throw new Exception();
        }
        catch(Exception e){
            StackTraceElement stes[]= e.getStackTrace();
            String serviceImpleClassName=   stes[1].getClassName();
            try {
                Class  serviceImplClazz= Class.forName(serviceImpleClassName);
                String serviceImpleClassSimpleName = serviceImplClazz.getSimpleName();
                String pojoSimpleName = serviceImpleClassSimpleName.replaceAll("ServiceImpl", "");
                String pojoPackageName = serviceImplClazz.getPackage().getName().replaceAll(".service.impl", ".pojo");
                String pojoFullName = pojoPackageName +"."+ pojoSimpleName;
                clazz=Class.forName(pojoFullName);
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public List list() {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.addOrder(Order.desc("id"));
        return findByCriteria(dc);
    }
    @Override
    public int total() {
        String hql = "select count(*) from " + clazz.getName() ;
        List<Long> l= find(hql);
        if(l.isEmpty())
            return 0;
        Long result= l.get(0);
        return result.intValue();
    }
    @Override
    public List<Object> listByPage(Page page) {
        DetachedCriteria dc = DetachedCriteria.forClass(clazz);
        dc.addOrder(Order.desc("id"));
        return findByCriteria(dc,page.getStart(),page.getCount());
    }
    @Override
    public Integer save(Object object) {
        return (Integer) super.save(object);
    }

    @Override
    public Object get(Class clazz, int id) {
        return super.get(clazz, id);
    }


    @Override
    public Object get(int id) {
        return get(clazz, id);
    }

// 	  因为继承了ServiceDelegateDAO，所以就继承了update和delete方法
//    public void update(Object object) {
//        update(object);
//    }
//    public void delete(Object object) {
//        delete(object);
//    }
}
