package com.zhouyunji.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = (String) request.getHeader("token");
        request.setAttribute("userId","1");

        System.out.println("preHandle----" + token + " ::: " + request.getRequestURL());
        //TODO 此处需要做一个token解码校验
        if (token == null) {
            // 跳转到登录页面
            System.out.println("preHandle----"+ "notoken" + " ::: " + request.getRequestURL());
            return false;
        }
        return true;
    }
}
