package com.wenhao.pss.web;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wenhao.pss.domain.Department;
import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.page.EmployeeQuery;
import com.wenhao.pss.page.PageResult;
import com.wenhao.pss.service.IDepartmentService;
import com.wenhao.pss.service.IEmployeeService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by lenovo on 2016/10/07.
 */
public class EmployeeAction extends CRUDAction {
    private IEmployeeService employeeService;
    private IDepartmentService departmentService;
    private PageResult<Employee> pageResult;
    private Employee employee;
    private EmployeeQuery baseQuery = new EmployeeQuery();


    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //列表
    @Override
    public String list() {
        putContext("allDepts", departmentService.getAll());
        this.pageResult = employeeService.find(baseQuery);
        return SUCCESS;
    }

    //新增或修改页面
    @Override
    public String input() {
        putContext("allDepts", departmentService.getAll());
        return INPUT;
    }

    public void validateSave() {
        if (StringUtils.isBlank(employee.getName())) {
            addFieldError(employee.getName(), "用户名必须填写");
        }
    }

    //保存
    @Override
    @InputConfig(methodName = "input")
    public String save() {
        Department department = employee.getDepartment_id();
        if (department != null && department.getId() != null && department.getId() == -1L) {
            employee.setDepartment_id(null);
        }
        try {
            if (id == null) {
                employeeService.save(employee);
                addActionMessage("保存成功");
            } else {
                employeeService.update(employee);
                addActionMessage("更新成功");
            }
        } catch (Exception e) {
            addActionError("异常" + e.getMessage());
            return input();
        }
        return RELOAD;
    }

    //删除
    @Override
    public String delete() {
        if (id != null) {
            employeeService.delete(id);
            addActionMessage("删除成功");
        }
        return RELOAD;
    }

    public PageResult<Employee> getPageResult() {
        return pageResult;
    }

    public EmployeeQuery getBaseQuery() {
        return baseQuery;
    }

    public void setBaseQuery(EmployeeQuery baseQuery) {
        this.baseQuery = baseQuery;
    }


    public Object getModel() {
        return employee;
    }

    public void beforeInput() {
        if (id != null) {
            this.employee = employeeService.get(id);
        }
    }

    public void beforeSave() {
        if (id == null) {
            employee = new Employee();
        } else {
            this.employee = employeeService.get(id);
            employee.setDepartment_id(null);
        }
    }
}
