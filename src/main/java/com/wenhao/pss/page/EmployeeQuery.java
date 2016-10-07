package com.wenhao.pss.page;

/**
 * Created by lenovo on 2016/10/07.
 */
public class EmployeeQuery extends BaseQuery {

    private String name;

    private long deptId;

    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDeptId() {
        return deptId;
    }

    public void setDeptId(long deptId) {
        this.deptId = deptId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
