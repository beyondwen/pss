package com.wenhao.pss.service;

import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.domain.Menu;

import java.util.List;

/**
 * Created by lenovo on 2016/10/07.
 */
public interface IMenuService extends IBaseService<Menu> {

    public List<Menu> getParentMenu(Employee loginUser);

    public List<Menu> getMenuByLoginUser(Employee loginUser,Long paretn_id);
}
