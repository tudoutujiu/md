package com.sdn.dao;

import com.sdn.pojo.fanta;

import java.util.List;

public interface fantaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(fanta record);

    int insertSelective(fanta record);

    fanta selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(fanta record);

    int updateByPrimaryKey(fanta record);

    List<fanta> getAll();
}