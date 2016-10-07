package com.wenhao.pss.web;

import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.service.IEmployeeService;

import java.util.List;

/**
 * Created by lenovo on 2016/10/07.
 */
public class EmployeeAction extends BaseAction {

    private IEmployeeService employeeService;
    private List<Employee> employees;
    private Employee employee;


    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //列表
    @Override
    public String execute() throws Exception {
        employees = employeeService.getAll();
        return SUCCESS;
    }

    //新增或修改页面
    @Override
    public String input() throws Exception {
        if (employee != null && employee.getId() != null) {
            this.employee = employeeService.get(employee.getId());
        }
        return INPUT;
    }

    //保存
    public String save() {
        if (employee.getId() == null) {
            employeeService.save(employee);
        } else {
            employeeService.update(employee);
        }
        return RELOAD;
    }

    //删除
    public String delete() {
        if (employee != null && employee.getId() != null) {
            employeeService.delete(employee.getId());
        }
        return RELOAD;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
