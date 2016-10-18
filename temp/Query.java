package com.wenhao.pss.page;

import com.wenhao.pss.domain.${domain};
import org.apache.commons.lang3.StringUtils;

/**
 * Created by lenovo on 2016/10/07.
 */
public class ${domain}Query extends BaseQuery {
    private String name;

    public ${domain}Query() {
        super(${domain}.class);
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
