package com.wenhao.pss.web;

import org.apache.struts2.ServletActionContext;

/**
 * Created by lenovo on 2016/10/22.
 */
public class LogoutAction extends BaseAction {

    @Override
    public String execute() throws Exception {
        ServletActionContext.getRequest().getSession().invalidate();
        return LOGIN;
    }
}
