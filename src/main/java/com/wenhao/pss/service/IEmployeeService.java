package com.wenhao.pss.service;

import com.wenhao.pss.domain.Employee;

/**
 * Created by lenovo on 2016/10/07.
 */
public interface IEmployeeService extends IBaseService<Employee> {

    boolean findByName(String name);

    Employee findByLogin(String name, String password);
}
