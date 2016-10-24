package com.wenhao.pss.domain;

import org.apache.struts2.json.annotations.JSON;

/**
 * Created by lenovo on 2016/10/22.
 */
public class Menu extends EnityId {
    private String name;
    private String url;
    private String icon;
    private Menu parent;

    public boolean getIsParent() {
        return parent == null;
    }

    public String getTarget() {
        return getParent() == null ? "" : "main";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JSON(serialize = false)
    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
