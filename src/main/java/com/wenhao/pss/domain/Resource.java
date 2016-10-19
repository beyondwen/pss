package com.wenhao.pss.domain;

/**
 * Created by lenovo on 2016/10/19.
 * 权限控制资源类
 */
public class Resource extends EnityId {
    private String name;
    private String method;
    private String descs;

    public Resource() {
    }

    public Resource(Long id) {
        this.id = id;
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

    public String getDescs() {
        return descs;
    }

    public void setDescs(String descs) {
        this.descs = descs;
    }
}
