package com.wenhao.pss.web.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.service.IEmployeeService;
import com.wenhao.pss.web.BaseAction;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.views.jsp.ui.SubmitTag;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lenovo on 2016/10/21.
 */
public class AuthInterceptor extends AbstractInterceptor {
    private List<String> actions;

    private IEmployeeService employeeService;

    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Object action = invocation.getAction();
        System.out.println("AuthInterceptor begin..." + action);
        // 1.对一些不需要拦截的action先放行
        if (actions.contains(action.getClass().getSimpleName())) {
            return invocation.invoke();// 进入下一个拦截器
        }

        // 2.判断是否登录
        Employee employee = (Employee) ServletActionContext.getRequest().getSession().getAttribute(BaseAction.USER_IN_SESSION);
        if (employee == null) {
            return Action.LOGIN;
        }

        //3.进行用户得权限得判断
        //获得访问action的全限定名
        String accessActionName = action.getClass().getName();
        //获得访问action的方法
        String accessActionMethod = invocation.getProxy().getMethod();
        //获得所有访问action的全限定名和方法
        String allAccessActionNameMethod = accessActionName + "." + accessActionMethod;
        String allAccessActionNameMethodOfALL = accessActionName + "." + "ALL";
        //获得resource的所有需要拦截的方法
        List<String> allResourceMethod = employeeService.findResourceMethod();
        List<String> loginUserResourceMethod = employeeService.findResourceByLogin(employee);
        if (allResourceMethod.contains(allAccessActionNameMethod)) {
            if (loginUserResourceMethod.contains(allAccessActionNameMethod) || loginUserResourceMethod.contains(allAccessActionNameMethodOfALL)) {
                return invocation.invoke();
            } else {
                return "auth";
            }
        }
        String result = invocation.invoke();// 进入下一个拦截器
        System.out.println("AuthInterceptor end..." + action);
        return result;
    }

    // <param name="actions">LoginAction,LogoutAction</param>
    public void setActions(String actions) {
        this.actions = Arrays.asList(actions.split(","));
    }
}
