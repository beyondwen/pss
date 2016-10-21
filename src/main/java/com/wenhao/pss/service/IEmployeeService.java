package com.wenhao.pss.service;

import com.wenhao.pss.domain.Employee;

import java.util.List;

/**
 * Created by lenovo on 2016/10/07.
 */
public interface IEmployeeService extends IBaseService<Employee> {

    boolean findByName(String name);

    Employee findByLogin(String name, String password);

    List<String> findResourceMethod();

    List<String> findResourceByLogin(Employee loginUser);


}
