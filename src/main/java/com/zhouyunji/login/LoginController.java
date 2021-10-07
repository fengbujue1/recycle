package com.zhouyunji.login;

import com.zhouyunji.bean.LoginData;
import com.zhouyunji.common.SessionKeys;
import com.zhouyunji.dao.OPTMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private OPTMapper OPTMapper;

    @RequestMapping("/toLogin")
    public String toLogin() {
        //返回登录页面
        return "login";
    }
    @RequestMapping("/reLogin")
    public String reLogin() {
        //返回登录页面
        return "login";
    }

    @RequestMapping("/login")
    public String login(LoginData loginData, HttpSession session) {
        LoginData result = OPTMapper.selectUser(loginData.getUserName());
        if (result != null && loginData.getPassWord().equals(result.getPassWord())) {
            session.setAttribute(SessionKeys.USER_ID, result.getUserId());
            //返回主页面
            return "home";
        } else {
            return "reLogin";
        }

    }
}
