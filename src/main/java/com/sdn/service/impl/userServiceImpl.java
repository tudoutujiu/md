package com.sdn.service.impl;

import com.sdn.dao.userMapper;
import com.sdn.pojo.user;
import com.sdn.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {
    @Autowired
    userMapper dao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(user user) {
        return dao.insert(user);
    }

    @Override
    public int insertSelective(user user) {
        return 0;
    }

    @Override
    public user selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(user user) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(user user) {
        return 0;
    }

    @Override
    public user getInstanceByName(String name) {
        return dao.getInstanceByName(name);
    }
}
