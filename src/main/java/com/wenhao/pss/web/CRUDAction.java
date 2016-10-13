package com.wenhao.pss.web;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;

/**
 * Created by Administrator on 2016/10/10 0010.
 */
public abstract class CRUDAction extends BaseAction implements ModelDriven, Preparable {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    @InputConfig(methodName = "execute")
    public String execute() throws Exception {
        list();
        return SUCCESS;
    }

    public abstract String list();

    @Override
    public String input() throws Exception {
        return INPUT;
    }

    public abstract String save();

    public abstract String delete();

    public void prepare() throws Exception {

    }

    public void prepareInput() throws Exception {
        beforeInput();
    }

    public void prepareSave() throws Exception {
        beforeSave();
    }

    public abstract void beforeInput();

    public abstract void beforeSave();
}
