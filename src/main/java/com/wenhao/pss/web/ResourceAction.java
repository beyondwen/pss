package com.wenhao.pss.web;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.wenhao.pss.domain.Resource;
import com.wenhao.pss.page.ResourceQuery;
import com.wenhao.pss.page.PageResult;
import com.wenhao.pss.service.IResourceService;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

/**
 * Created by lenovo on 2016/10/07.
 */
public class ResourceAction extends CRUDAction {
    private IResourceService resourceService;
    private PageResult<Resource> pageResult;
    private Resource resource;
    private ResourceQuery baseQuery = new ResourceQuery();
    private String name;


    public void setResourceService(IResourceService resourceService) {
        this.resourceService = resourceService;
    }

    //列表
    @Override
    public String list() {
        //putContext("allDepts", departmentService.getAll());
        this.pageResult = resourceService.find(baseQuery);
        return SUCCESS;
    }

    //新增或修改页面
    @Override
    public String input() {
        //putContext("allDepts", departmentService.getAll());
        return INPUT;
    }

    public void validateSave() {
        if (StringUtils.isBlank(resource.getName())) {
            addFieldError(resource.getName(), "用户名必须填写");
        }
    }

    //保存
    @Override
    @InputConfig(methodName = "input")
    public String save() {
        try {
            if (id == null) {
                resourceService.save(resource);
                baseQuery.setCurrentPage(Integer.MAX_VALUE);
                addActionMessage("保存成功");
            } else {
                resourceService.update(resource);
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
                resourceService.delete(id);
                printWriter.write("{\"success\":true,\"msg\":\"删除成功\"}");
            } else {
                printWriter.write("{\"success\":false,\"msg\":\"id不存在\"}");
            }
        } catch (Exception e) {
            printWriter.write("{\"success\":false,\"msg\":\"异常:" + e.getMessage() + "\"}");
        }
        return NONE;
    }

    public PageResult<Resource> getPageResult() {
        return pageResult;
    }

    public ResourceQuery getBaseQuery() {
        return baseQuery;
    }

    public void setBaseQuery(ResourceQuery baseQuery) {
        this.baseQuery = baseQuery;
    }


    public Object getModel() {
        return resource;
    }

    public void beforeInput() {
        if (id != null) {
            this.resource = resourceService.get(id);
        }
    }

    public void beforeSave() {
        if (id == null) {
            resource = new Resource();
        } else {
            this.resource = resourceService.get(id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
