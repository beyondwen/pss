package com.wenhao.pss.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by lenovo on 2016/10/21.
 */
public class AuthInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation invocation) throws Exception {
        Object action = invocation.getAction();
        System.out.println(action);
        return null;
    }
}
