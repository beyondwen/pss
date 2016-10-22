package com.wenhao.pss.service.impl;

import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.service.IEmployeeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void findResourceMethod() {
        List<String> allMethod = employeeService.findResourceMethod();
        for (String method : allMethod) {
            System.out.println(method);
        }
    }

    @Test
    public void findResourceByLogin() {
        Employee loginUser = employeeService.get(1L);
        List<String> allMethod = employeeService.findResourceByLogin(loginUser);
        for (String method : allMethod) {
            System.out.println(method);
        }
    }

}