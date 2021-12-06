package com.zhouyunji.login;

import com.zhouyunji.common.SessionKeys;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = (String) request.getHeader("Authorization");
        request.setAttribute("userId","1");

        System.out.println("preHandle----"+ authorization + " ::: " + request.getRequestURL());
//        if (authorization == null) {
//            // 跳转到登录页面
//            response.sendRedirect("/QR/toLogin");
//            return true;
//        }
        return true;
    }
}
