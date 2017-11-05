package com.tmall.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by OovEver on 2017/11/1.
 */
@Repository("dao")
public class DAOImpl extends HibernateTemplate {
//    按照名称进行装配
    @Resource(name ="sf")
    public void setSessionFactory(SessionFactory sessionFactory) {
        super.setSessionFactory(sessionFactory);
    }
}
