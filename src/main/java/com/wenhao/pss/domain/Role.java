package com.wenhao.pss.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2016/10/19.
 */
public class Role extends EnityId {

    private String name;

    private Set<Resource> resources = new HashSet<Resource>();

    private Set<Menu> menus = new HashSet<Menu>();

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
