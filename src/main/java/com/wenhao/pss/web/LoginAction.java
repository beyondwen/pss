package com.wenhao.pss.web;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.service.IEmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

/**
 * Created by lenovo on 2016/10/20.
 */
public class LoginAction extends BaseAction {

    private String name;
    private String password;

    private IEmployeeService employeeService;

    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public String execute() throws Exception {
        return LOGIN;
    }

    public void validateCheck() {
        if (StringUtils.isBlank(name)) {
            addFieldError("name", "用户名必须填写");
        }
    }

    @InputConfig(resultName = "login")
    public String check() {
        if (StringUtils.isBlank(name)) {
            addFieldError("name", "用户名必须填写");
        }
        Employee employee = employeeService.findByLogin(name, password);
        if (employee != null) {
            ServletActionContext.getRequest().getSession().setAttribute("USER_IN_SESSION", employee);
            return "main";
        } else {
            addActionError("用户名或密码错误");
        }

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
