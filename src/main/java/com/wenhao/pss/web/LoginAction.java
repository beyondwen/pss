package com.wenhao.pss.web;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.service.IEmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2016/10/20.
 */
public class LoginAction extends BaseAction {
    private IEmployeeService employeeService;
    private String name;
    private String password;

    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // 显示登录页面
    @Override
    public String execute() throws Exception {
        return LOGIN;
    }

    public void validateCheck() {
        if (StringUtils.isBlank(name)) {
            addFieldError("name", "用户名必须填写");
        }
    }

    // 处理登录请求
    @InputConfig(resultName = "login")
    public String check() throws Exception {
        Employee employee = employeeService.findByLogin(name, password);
        if (employee != null) {// 登录成功
            HttpSession session = ServletActionContext.getRequest()
                    .getSession();
            session.setAttribute(USER_IN_SESSION, employee);
            return "main";// 重定向
        }
        addActionError("登录失败");
        return LOGIN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
