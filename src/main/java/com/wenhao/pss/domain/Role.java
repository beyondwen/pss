package com.wenhao.pss.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lenovo on 2016/10/19.
 */
public class Role extends EnityId {

    private String name;

    private Set<Resource> resources = new HashSet<Resource>();

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
}
