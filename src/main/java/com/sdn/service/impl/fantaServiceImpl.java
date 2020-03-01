package com.sdn.service.impl;

import com.sdn.dao.fantaMapper;
import com.sdn.dao.roleMapper;
import com.sdn.pojo.fanta;
import com.sdn.service.fantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class fantaServiceImpl implements fantaService {
    @Autowired
    fantaMapper dao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(fanta fanta) {
        return dao.insert(fanta);
    }

    @Override
    public int insertSelective(fanta fanta) {
        return dao.insertSelective(fanta);
    }

    @Override
    public fanta selectByPrimaryKey(Integer id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(fanta fanta) {
        return dao.updateByPrimaryKeySelective(fanta);
    }

    @Override
    public int updateByPrimaryKey(fanta fanta) {
        return dao.updateByPrimaryKey(fanta);
    }

    @Override
    public List<fanta> getAll() {
        return dao.getAll();
    }
}
