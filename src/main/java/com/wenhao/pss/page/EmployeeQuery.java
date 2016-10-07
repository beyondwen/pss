package com.wenhao.pss.page;

import com.wenhao.pss.domain.Employee;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by lenovo on 2016/10/07.
 */
public class EmployeeQuery extends BaseQuery {
    private String name;

    private long deptId;

    private String email;

    public EmployeeQuery() {
        super(Employee.class);
    }

    protected void addWhere() {
        if (StringUtils.isNotBlank(name)) {
            addWhere(" o.name like ?", "%" + name + "%");
        }
        if (StringUtils.isNotBlank(email)) {
            addWhere(" o.email like ?", "%" + email + "%");
        }
    }

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
