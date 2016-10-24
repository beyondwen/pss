package com.wenhao.pss.service.impl;

import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.domain.Menu;
import com.wenhao.pss.service.IEmployeeService;
import com.wenhao.pss.service.IMenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2016/10/22.
 */
public class MenuServiceImplTest extends BaseServiceTest {

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IEmployeeService employeeService;

    @Test
    public void getAll() {
        int i = menuService.getAll().size();
        System.out.println(i);
    }

    @Test
    public void getParentMenu() throws Exception {
        Employee loginUser = employeeService.get(54L);
        List<Menu> parentMenu = menuService.getParentMenu(loginUser);
        for (Menu m : parentMenu) {
            System.out.println(m);
        }
    }

    @Test
    public void getMenuByLoginUser() throws Exception {
        Employee loginUser = employeeService.get(1L);
        List<Menu> parentMenu = menuService.getMenuByLoginUser(loginUser,1L);
        for (Menu m : parentMenu) {
            System.out.println(m);
        }
    }

}