package com.wenhao.pss.web;

import com.wenhao.pss.domain.Employee;
import com.wenhao.pss.domain.Menu;
import com.wenhao.pss.service.IMenuService;
import org.apache.struts2.ServletActionContext;

import java.io.PrintWriter;
import java.util.List;

/**
 * Created by lenovo on 2016/10/23.
 */
public class LeftAction extends BaseAction {

    private IMenuService menuService;

    private Long id;

    public void setMenuService(IMenuService menuService) {
        this.menuService = menuService;
    }

    /*@Override
    public String execute() throws Exception {
        PrintWriter writer = ServletActionContext.getResponse().getWriter();
        writer.print("[{\"id\":1,\"name\":\"abc\",\"isParent\":true},{\"id\":2,\"name\":\"abc\"}]");
        return null;
    }*/

    @Override
    public String execute() throws Exception {
        Employee employee = (Employee) ServletActionContext.getRequest().getSession().getAttribute("userInSession");
        List<Menu> menus = null;
        if (id == null) {
            menus = menuService.getParentMenu(employee);
        } else if (id != null) {
            menus = menuService.getMenuByLoginUser(employee, id);
        }
        putContext("map", menus);
        return JSON_RESULT;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   /* public String getName() {
        return "xxxx";
    }*/
}
