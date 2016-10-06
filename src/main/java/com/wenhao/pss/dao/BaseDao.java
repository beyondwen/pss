package com.wenhao.pss.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2016/10/06.
 */
public class BaseDao<T> extends HibernateDaoSupport {

    public void save(T t) {
        this.getHibernateTemplate().save(t);
    }

    public void update(T t) {
        this.getHibernateTemplate().update(t);
    }

    public void delete(Class<T> entityClass, Serializable id) {
        T t = get(entityClass, id);
        if (t != null) {
            this.getHibernateTemplate().delete(t);
        }
    }

    public T get(Class<T> entityClass, Serializable id) {
        return this.getHibernateTemplate().get(entityClass, id);
    }

    public List<T> getAll(Class<T> entityClass) {
        return this.getHibernateTemplate().loadAll(entityClass);
    }

}
