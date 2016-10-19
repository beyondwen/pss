package com.wenhao.pss.page;

import com.wenhao.pss.domain.Resource;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by lenovo on 2016/10/07.
 */
public class ResourceQuery extends BaseQuery {
    private String name;
    private String method;

    public ResourceQuery() {
        super(Resource.class);
    }

    protected void addWhere() {
        if (StringUtils.isNotBlank(name)) {
            addWhere(" o.name like ?", "%" + name + "%");
        }
        if (StringUtils.isNotBlank(method)) {
            addWhere(" o.method like ?", "%" + method + "%");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
