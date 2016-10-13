package com.wenhao.pss.service.impl;

import com.wenhao.pss.service.IEmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2016/10/13.
 */
public class EmployeeServiceImplTest extends BaseServiceTest{

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void findByName() throws Exception {
        System.out.println(employeeService.findByName("asdfg"));
        System.out.println(employeeService.findByName(""));
    }

}