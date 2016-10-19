package com.wenhao.pss.page;

import com.wenhao.pss.domain.Role;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by lenovo on 2016/10/07.
 */
public class RoleQuery extends BaseQuery {
    private String name;

    public RoleQuery() {
        super(Role.class);
    }

    protected void addWhere() {
        if (StringUtils.isNotBlank(name)) {
            addWhere(" o.name like ?", "%" + name + "%");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
