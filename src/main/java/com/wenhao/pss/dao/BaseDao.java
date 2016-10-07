package com.wenhao.pss.dao;

import com.wenhao.pss.page.BaseQuery;
import com.wenhao.pss.page.PageResult;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;
import java.sql.SQLException;
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

    //此处分页需要使用hibernate的session来完成所以通过这样获得，方便Spring管理
    public PageResult<T> find(BaseQuery baseQuery) {
        /*getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Object>() {
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return null;
            }
        });*/
        System.out.println(baseQuery.getCountHql());
        System.out.println(baseQuery.getHql());
        return null;
    }

}
