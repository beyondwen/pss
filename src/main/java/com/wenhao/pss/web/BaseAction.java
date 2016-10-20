package com.wenhao.pss.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import org.slf4j.Logger;

/**
 * Created by lenovo on 2016/10/07.
 */
public abstract class BaseAction extends ActionSupport {

    protected Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

    public static final String RELOAD = "reload";
    public static final String USER_IN_SESSION = "userinsession";

    protected void putContext(String key, Object o) {
        ActionContext.getContext().put(key, o);
    }
}
