package com.sdn.dao;

import com.sdn.pojo.role;

public interface roleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(role record);

    int insertSelective(role record);

    role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(role record);

    int updateByPrimaryKey(role record);
}