package com.wenhao.pss.page;

import com.wenhao.pss.domain.Menu;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by lenovo on 2016/10/07.
 */
public class MenuQuery extends BaseQuery {
    private String name;

    public MenuQuery() {
        super(Menu.class);
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
