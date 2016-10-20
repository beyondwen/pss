package com.wenhao.pss.web;

import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wenhao.pss.domain.Resource;
import com.wenhao.pss.domain.Role;
import com.wenhao.pss.page.PageResult;
import com.wenhao.pss.page.RoleQuery;
import com.wenhao.pss.service.IResourceService;
import com.wenhao.pss.service.IRoleService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Set;

/**
 * Created by lenovo on 2016/10/07.
 */
public class RoleAction extends CRUDAction {
    private IResourceService resourceService;
    private IRoleService roleService;
    private PageResult<Role> pageResult;
    private Role role;
    private RoleQuery baseQuery = new RoleQuery();
    private String name;
    private Long[] ids;


    public void setResourceService(IResourceService resourceService) {
        this.resourceService = resourceService;
    }

    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    //列表
    @Override
    public String list() {
        this.pageResult = roleService.find(baseQuery);
        return SUCCESS;
    }

    //新增或修改页面
    @Override
    public String input() {
        putContext("allResources", resourceService.getAll());
        return INPUT;
    }

    public void validateSave() {
        if (StringUtils.isBlank(role.getName())) {
            addFieldError(role.getName(), "用户名必须填写");
        }
    }

    //保存
    @Override
    @InputConfig(methodName = "input")
    public String save() {
        for (Long id:ids) {
            role.getResources().add(new Resource(id));
        }
        try {
            if (id == null) {
                roleService.save(role);
                baseQuery.setCurrentPage(Integer.MAX_VALUE);
                addActionMessage("保存成功");
            } else {
                roleService.update(role);
                addActionMessage("更新成功");
            }
        } catch (Exception e) {
            addActionError("异常" + e.getMessage());
            return input();
        }
        return RELOAD;
    }

    @Override
    public String delete() throws Exception {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setContentType("text/json; charset=utf-8");
        PrintWriter printWriter = ServletActionContext.getResponse().getWriter();
        try {
            if (id != null) {
                roleService.delete(id);
                printWriter.write("{\"success\":true,\"msg\":\"删除成功\"}");
            } else {
                printWriter.write("{\"success\":false,\"msg\":\"id不存在\"}");
            }
        } catch (Exception e) {
            printWriter.write("{\"success\":false,\"msg\":\"异常:" + e.getMessage() + "\"}");
        }
        return NONE;
    }

    public PageResult<Role> getPageResult() {
        return pageResult;
    }

    public RoleQuery getBaseQuery() {
        return baseQuery;
    }

    public void setBaseQuery(RoleQuery baseQuery) {
        this.baseQuery = baseQuery;
    }


    public Object getModel() {
        return role;
    }

    public void beforeInput() {
        if (id != null) {
            this.role = roleService.get(id);
            Set<Resource> resources = role.getResources();//获得中间表
            ids = new Long[resources.size()];
            int index = 0;
            for (Resource resource : resources) {
                ids[index++] = resource.getId();
            }
        }
    }

    public void beforeSave() {
        if (id == null) {
            role = new Role();
        } else {
            this.role = roleService.get(id);
            //role.setResources(null);用于修改角色所拥有的资源，这样会报空指针异常
            //role.setResources(new HashSet<Resource>());这个不会报错，但是性能不好
            role.getResources().clear();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long[] getIds() {
        return ids;
    }

    public void setIds(Long[] ids) {
        this.ids = ids;
    }
}
