package com.wenhao.pss.service.impl;

import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.domain.Menu;
import com.wenhao.pss.service.IMenuService;

import java.util.List;

/**
 * Created by lenovo on 2016/10/07.
 */
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {

    public List<Menu> getParentMenu(Employee loginUser) {
        String hql = "select distinct m from Employee e join e.roles r join r.menus m where e=? and m.parent is null";
        return baseDao.findByName(hql,loginUser);
    }

    public List<Menu> getMenuByLoginUser(Employee loginUser,Long paretn_id) {
        String hql = "select distinct m from Employee e join e.roles r join r.menus m where e=? and m.parent.id=?";
        return baseDao.findByName(hql,loginUser,paretn_id);
    }
}
