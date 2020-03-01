package com.sdn.app;

import com.sdn.pojo.user;
import com.sdn.service.impl.userServiceImpl;
import com.sdn.service.userService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
import java.util.UUID;

public class register {
    public static void main(String[] args) {

        String hash="MD5";

        int hashInter = 2;

        Scanner scan=new Scanner(System.in);

        System.out.println("========= 用户注册 ========");
        System.out.println("请输入用户名:");
        String username=scan.next();
        System.out.println("请输入密码:");
        String password=scan.next();
        String salt=new SecureRandomNumberGenerator().nextBytes().toHex();
        System.out.println("得到盐:"+salt);
        String modulate_salt=username+salt;//这个modulate_salt用来计算密码的密文
        //计算密码密文
        System.out.println("得到调制盐(即salt+username):"+salt);
        String modulate_password=new SimpleHash(hash, password, modulate_salt,hashInter).toString();
        System.out.println("得到两次md5加密后的密文"+modulate_password);
        user u=new user();

        u.setName(username);
        u.setPassword(modulate_password);
        u.setSalt(salt);
        u.setRoleids("2");

        //ApplicationContext ac=new AnnotationConfigApplicationContext("com.j1903");
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        //userBiz biz=new userBizimpl();我们不能这么自已做实例化，因为这样dao无法注入进入biz
        userService biz=(userServiceImpl) ac.getBean("userServiceImpl");
        if(biz.insert(u)==1){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }

    }
}
