package com.wenhao.pss.service.impl;

import com.wenhao.pss.dao.BaseDao;
import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.page.BaseQuery;
import com.wenhao.pss.page.EmployeeQuery;
import com.wenhao.pss.page.PageResult;
import com.wenhao.pss.service.IBaseService;
import com.wenhao.pss.service.IEmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2016/10/07.
 */
public class BaseServiceImplTest extends BaseServiceTest {


    @Autowired
    private IBaseService baseService;

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void save() throws Exception {
        Employee employee = new Employee();
        employee.setName("xxx");
        employee.setAge(20);
        employee.setEmail("xxxx");
        baseService.save(employee);
    }

    @Test
    public void update() throws Exception {
        Employee employee = new Employee();
        employee.setName("wenhao");
        employee.setAge(20);
        employee.setEmail("xxxx");
        employee.setId(105L);
        baseService.update(employee);
    }

    @Test
    public void delete() throws Exception {
        baseService.delete(105L);
    }

    @Test
    public void get() throws Exception {
        Employee employee = (Employee) baseService.get(104L);
        System.out.println(employee.getName());
    }

    @Test
    public void getAll() throws Exception {
        List<Employee> employees = baseService.getAll();
        for (Employee e : employees) {
            System.out.println(e.getName());
        }
    }

    @Test
    public void find() throws Exception {
        EmployeeQuery employeeQuery = new EmployeeQuery();
        //employeeQuery.setEmail("921790476@qq.coom");
        employeeQuery.setName("roleAdmin");
        PageResult<Employee> employeePageResult = employeeService.find(employeeQuery);
        System.out.println(employeePageResult);
    }

}