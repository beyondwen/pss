package com.wenhao.pss.page;

import com.wenhao.pss.domain.Dept;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by lenovo on 2016/10/07.
 */
public class DeptQuery extends BaseQuery {
    private String name;

    public DeptQuery() {
        super(Dept.class);
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