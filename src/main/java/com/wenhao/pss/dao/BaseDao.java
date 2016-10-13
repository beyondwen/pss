package com.wenhao.pss.dao;

import com.wenhao.pss.page.BaseQuery;
import com.wenhao.pss.page.PageResult;
import org.hibernate.HibernateException;
import org.hibernate.Query;
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
    public PageResult<T> find(final BaseQuery baseQuery) {
        //通过匿名类来获得原生session
        Long countLong = getHibernateTemplate().executeWithNativeSession(new HibernateCallback<Long>() {
            public Long doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery(baseQuery.getCountHql());
                buildQuery(query, baseQuery);
                return (Long) query.uniqueResult();
            }
        });
        if (countLong.intValue() == 0) {
            return new PageResult<T>();
        }
        final PageResult<T> pageResult = new PageResult<T>(baseQuery.getCurrentPage(), baseQuery.getPageSize(), countLong.intValue());

        List<T> rows = getHibernateTemplate().executeWithNativeSession(new HibernateCallback<List<T>>() {
            public List<T> doInHibernate(Session session) throws HibernateException, SQLException {
                Query query = session.createQuery(baseQuery.getHql());
                buildQuery(query, baseQuery);
                int firstResult = (pageResult.getCurrentPage() - 1) * pageResult.getPageSize();
                int maxResult = pageResult.getPageSize();
                query.setFirstResult(firstResult).setMaxResults(maxResult);
                return query.list();
            }
        });
        pageResult.setRow(rows);
        return pageResult;
    }

    private void buildQuery(Query query, BaseQuery baseQuery) {
        int index = 0;
        for (Object object : baseQuery.getParamList()) {
            query.setParameter(index++, object);
        }
    }

    public List findByName(String hql, Object... objects) {
        List list = this.getHibernateTemplate().find(hql, objects);
        return list;
    }

}
