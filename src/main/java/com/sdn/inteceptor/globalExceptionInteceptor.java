package com.sdn.inteceptor;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component//就是在spring容器中托管这个类，它会由spring 来管理
public class globalExceptionInteceptor implements HandlerExceptionResolver   {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                         Object handler, Exception ex) {
        /*if(ex instanceof authorityException){
          int errorCode=  ((authorityException) ex).getCode();
          if(errorCode==0){
              //没有登录
              return  new ModelAndView("login");
          }else if(errorCode==1){
              //无权操作
              return  new ModelAndView("authrity_error");
          }

        }*/
        return null;
    }
}
