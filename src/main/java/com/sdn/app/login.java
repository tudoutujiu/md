package com.sdn.app;


import com.sdn.pojo.user;
import com.sdn.service.impl.userServiceImpl;
import com.sdn.service.userService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class login {
    //控制台模拟登录
    public static void main(String[] args) {
        String hash="MD5";

        int hashInter = 2;


        Scanner scan=new Scanner(System.in);

        System.out.println("========= 用户注册 ========");
        System.out.println("请输入用户名:");
        String username=scan.next();
        System.out.println("请输入密码:");
        String password=scan.next();
        //获取spring容器
        ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过容器获取一个userBiz,不能 new 实例化出来
        userService biz=(userServiceImpl) ac.getBean("userServiceImpl");

        //利用biz，传入name ，获取一个用户
        user u=biz.getInstanceByName(username);
        if(u!=null){
            //说明取得到 ，确有一个叫这个名字的用户
            String modulate_salt=u.getName()+u.getSalt();
            //计算密码密文
            String modulate_password=new SimpleHash("MD5", password, modulate_salt,2).toString();

            if(u.getPassword().equals(modulate_password)){
                System.out.println("登录成功");
            }else{
                System.out.println("登录失败");
            }
        }else{
            System.out.println("登录失败");
        }

    }
}
