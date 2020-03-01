package com.sdn.realm;


import com.sdn.pojo.user;
import com.sdn.service.resourceService;
import com.sdn.service.userService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;


public class myrealm extends AuthorizingRealm {
    @Autowired
    userService user_biz;

    @Autowired
    resourceService res_biz;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //这个是授权方法，我们将把用户所有的权限字符串加入到authorizationInfo
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        //我们从入参principal中取出主principal就是用户名
        String username=(String)principalCollection.getPrimaryPrincipal();
        //我们通过用户名，获取到用户的所有权限字符串,这时候我们需要注入一个biz
        Set<String> set=res_biz.getPermission(user_biz.getInstanceByName(username));
        //注入authorizationInfo
        authorizationInfo.setStringPermissions(set);
        SecurityUtils.getSubject().getSession().setAttribute("userPermission",set);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //此方法作用就是做登录验证
        //1  从入参（authenticationToken令牌）获取用户名及密码
        String username=authenticationToken.getPrincipal().toString();
        //2  通过用户名取出用户对象
        user u=user_biz.getInstanceByName(username);


        //3 传递用户名，密码明文 ，调制盐,realm的名称 为参数
        //  创建一个 SimpleAuthenticationInfo 对象 然后返回这个对象
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(
                u.getName(),//用户名
                u.getPassword(),//密码密文
                ByteSource.Util.bytes(u.getCredentialsSalt()),//调制盐
                getName()
        );
        //Set<String> set=res_biz.getPermission(user_biz.getInstanceByName(username));


        SecurityUtils.getSubject().getSession().setAttribute("userKey",u);
        return simpleAuthenticationInfo;
    }
}
