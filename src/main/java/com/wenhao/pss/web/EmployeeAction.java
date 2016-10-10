package com.wenhao.pss.web;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.page.EmployeeQuery;
import com.wenhao.pss.page.PageResult;
import com.wenhao.pss.service.IEmployeeService;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by lenovo on 2016/10/07.
 */
public class EmployeeAction extends BaseAction implements ModelDriven, Preparable {


    private IEmployeeService employeeService;
    private PageResult<Employee> pageResult;
    private Employee employee;
    private EmployeeQuery baseQuery = new EmployeeQuery();
    private Long id;


    public void setEmployeeService(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //列表
    @Override
    public String execute() throws Exception {
        this.pageResult = employeeService.find(baseQuery);
        return SUCCESS;
    }

    //新增或修改页面
    @Override
    public String input() throws Exception {
        if (id != null) {
            this.employee = employeeService.get(id);
        }
        return INPUT;
    }

    //保存
    public String save() {
        System.out.println("save");
        if (id == null) {
            employeeService.save(employee);
        } else {
            employeeService.update(employee);
        }
        return RELOAD;
    }

    //删除
    public String delete() {
        if (id != null) {
            employeeService.delete(id);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getModel() {
        return employee;
    }

    public void prepare() throws Exception {

    }

    public void prepareInput() throws Exception {
        if (id != null) {
            this.employee = employeeService.get(id);
        }
    }

    public void prepareSave() throws Exception {
        if (id != null) {
            this.employee = employeeService.get(id);
        } else {
            employee = new Employee();
        }
    }
}
