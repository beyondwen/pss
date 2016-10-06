package com.wenhao.pss.service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lenovo on 2016/10/06.
 */
public interface IBaseService<T> {
    void save(T t);

    void update(T t);

    void delete(Serializable id);

    T get(Serializable id);

    List<T> getAll();
}
