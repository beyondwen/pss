package com.wenhao.pss.web;

import com.wenhao.pss.domain.Department;
import com.wenhao.pss.page.DepartmentQuery;
import com.wenhao.pss.page.PageResult;
import com.wenhao.pss.service.IDepartmentService;

/**
 * Created by lenovo on 2016/10/07.
 */
public class DepartmentAction extends CRUDAction {
    private IDepartmentService departmentService;
    private PageResult<Department> pageResult;
    private Department department;
    private DepartmentQuery baseQuery = new DepartmentQuery();


    public void setDepartmentService(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    //列表
    @Override
    public String list() {
        this.pageResult = departmentService.find(baseQuery);
        return SUCCESS;
    }

    //新增或修改页面
    @Override
    public String input() {
        if (id != null) {
            this.department = departmentService.get(id);
        }
        return INPUT;
    }

    //保存
    @Override
    public String save() {
        if (id == null) {
            departmentService.save(department);
        } else {
            departmentService.update(department);
        }
        return RELOAD;
    }

    //删除
    @Override
    public String delete() {
        if (id != null) {
            departmentService.delete(id);
        }
        return RELOAD;
    }

    public PageResult<Department> getPageResult() {
        return pageResult;
    }

    public DepartmentQuery getBaseQuery() {
        return baseQuery;
    }

    public void setBaseQuery(DepartmentQuery baseQuery) {
        this.baseQuery = baseQuery;
    }


    public Object getModel() {
        return department;
    }

    public void beforeInput() {
        if (id != null) {
            this.department = departmentService.get(id);
        }
    }

    public void beforeSave() {
        if (id != null) {
            this.department = departmentService.get(id);
        } else {
            department = new Department();
        }
    }
}
