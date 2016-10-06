package com.wenhao.pss.service.impl;

import com.wenhao.pss.dao.BaseDao;
import com.wenhao.pss.service.IBaseService;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lenovo on 2016/10/06.
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    private Class<T> entiyClass;

    private BaseDao baseDao;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    public BaseServiceImpl() {
        Class serviceClazz = getClass();
        Type type = serviceClazz.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            entiyClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        }
    }

    public void save(Object o) {
        baseDao.save(o);
    }

    public void update(Object o) {
        baseDao.update(o);
    }

    public void delete(Serializable id) {
        baseDao.delete(entiyClass, id);
    }

    public T get(Serializable id) {
        return (T) baseDao.get(entiyClass, id);
    }

    public List<T> getAll() {
        return (List<T>) baseDao.getAll(entiyClass);
    }
}
