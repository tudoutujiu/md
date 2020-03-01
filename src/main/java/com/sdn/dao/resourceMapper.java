package com.sdn.dao;

import com.sdn.pojo.resource;
import com.sdn.pojo.user;

import java.util.List;
import java.util.Set;

public interface resourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(resource record);

    int insertSelective(resource record);

    resource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(resource record);

    int updateByPrimaryKey(resource record);

    List<resource> getAll();

    Set<String> getPermission(user u);
}