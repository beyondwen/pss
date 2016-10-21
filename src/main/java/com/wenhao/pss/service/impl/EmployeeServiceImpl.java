package com.wenhao.pss.service.impl;

import com.wenhao.pss.dao.BaseDao;
import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.service.IEmployeeService;

import java.util.List;

/**
 * Created by lenovo on 2016/10/07.
 */
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements IEmployeeService {


    public boolean findByName(String name) {
        String count = "select count(o) from Employee o where o.name=?";
        List<Long> namenum = baseDao.findByName(count, name);
        if (namenum.get(0).intValue() == 0) {
            return true;
        }
        return false;
    }

    public Employee findByLogin(String name, String password) {
        String hql = "select o from Employee o where o.name=? and o.password=?";
        List<Employee> employees = baseDao.findByName(hql, name, password);
        if (employees.size() == 1) {
            return employees.get(0);
        }
        return null;
    }

    public List<String> findResourceMethod() {
        String hql = "select o.method from Resource o";
        return baseDao.findByName(hql);
    }

    public List<String> findResourceByLogin(Employee loginUser) {
        String hql = "select distinct e.method from Employee o join o.roles r join r.resources e where o=?";
        return baseDao.findByName(hql, loginUser);
    }
}
