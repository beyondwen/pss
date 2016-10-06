package com.wenhao.pss.domain;

import java.io.Serializable;

/**
 * Created by lenovo on 2016/10/06.
 */
public abstract class EnityId implements Serializable{

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
