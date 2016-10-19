package com.wenhao.pss.service.impl;

import com.wenhao.pss.service.IResourceService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2016/10/19.
 */
public class ResourceServiceImplTest extends BaseServiceTest {

    @Autowired
    private IResourceService resourceService;

    @Test
    public void getSize() {
        System.out.println(resourceService.getAll().size());
    }

}