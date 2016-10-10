package com.wenhao.pss.service.impl;

import com.wenhao.pss.domain.Department;
import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.page.EmployeeQuery;
import com.wenhao.pss.page.PageResult;
import com.wenhao.pss.service.IBaseService;
import com.wenhao.pss.service.IDepartmentService;
import com.wenhao.pss.service.IEmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by lenovo on 2016/10/07.
 */
public class DepartmentServiceTest extends BaseServiceTest {


    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void save() throws Exception {
        List<Department> departments = departmentService.getAll();
        System.out.println(departments.size());
    }


}