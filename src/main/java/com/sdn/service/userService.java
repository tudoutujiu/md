package com.sdn.service;

import com.sdn.pojo.user;

public interface userService extends baseService<user> {
    //通过名字获取到一个用户对象
    user getInstanceByName(String name);
}
