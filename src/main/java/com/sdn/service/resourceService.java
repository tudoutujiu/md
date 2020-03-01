package com.sdn.service;

import com.sdn.pojo.resource;
import com.sdn.pojo.user;

import java.util.Set;

public interface resourceService extends baseService<resource> {
    //在系统中的所有权限字符串
    public Set<String> getPermission(user u);
}
