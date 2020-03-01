package com.sdn.service.impl;

import com.sdn.dao.resourceMapper;
import com.sdn.dao.roleMapper;
import com.sdn.pojo.resource;
import com.sdn.pojo.role;
import com.sdn.pojo.user;
import com.sdn.service.resourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class resourceServiceImpl implements resourceService {
    @Autowired
    resourceMapper reso_dao;
    @Autowired
    roleMapper role_dao;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }

    @Override
    public int insert(resource resource) {
        return 0;
    }

    @Override
    public int insertSelective(resource resource) {
        return 0;
    }

    @Override
    public resource selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(resource resource) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(resource resource) {
        return 0;
    }

    /**
     * 返回值set 就是我们一个登录账号的所有权限集合
     */
    @Override
    public Set<String> getPermission(user u) {

        Set<String> set=new HashSet<String>();

        String roleids=u.getRoleids();//1,3,5,8
        String[] role_ids=roleids.split(",");

        for(int i=0;i<role_ids.length;i++) {
            int roleid=Integer.parseInt(role_ids[i]);
            //根据roleid可以取出一个role 来
            role role_=role_dao.selectByPrimaryKey(roleid);

            String resourceids=role_.getResourceid();
            String[] resource_ids=resourceids.split(",");
            for(int j=0;j<resource_ids.length;j++) {
                int resourceid=Integer.parseInt(resource_ids[j]);

                resource resource_=reso_dao.selectByPrimaryKey(resourceid);
                set.add(resource_.getPermission());
            }
        }
        return set;
    }
}
