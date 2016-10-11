package com.wenhao.pss.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by lenovo on 2016/10/07.
 */
public abstract class BaseAction extends ActionSupport {

    public static final String RELOAD = "reload";

    protected void putContext(String key,Object o){
        ActionContext.getContext().put(key, o);
    }
}
