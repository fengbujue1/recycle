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
        Object user = request.getSession().getAttribute(SessionKeys.USER_ID);
        System.out.println("preHandle----"+ user + " ::: " + request.getRequestURL());
        if (user == null) {
            // 跳转到登录页面
            response.sendRedirect("/QR/toLogin");
            return false;
        }
        return true;
    }
}
