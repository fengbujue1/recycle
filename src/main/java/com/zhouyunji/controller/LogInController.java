package com.zhouyunji.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhouyunji.bean.user.RegisterInfo;
import com.zhouyunji.bean.user.UserInfoVO;
import com.zhouyunji.service.UserService;
import com.zhouyunji.util.HTTPUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户信息管理
 */
@Controller()
@RequestMapping("/login")
public class LogInController {

    @Autowired
    UserService userService;

    /**
     * 用户自动注册，在小程序首页加载的时候自动调入
     * 自动调入：1不存在 nickname 或img  不返回token
     * 2.存在 nickname 或img  返回token
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public UserInfoVO login(String code) throws Exception {
        return userService.addUser(code);
    }

    /**
     * 用户手动调入，传 nickname 和img 用于补全用户信息
     *
     * @param registerInfo
     * @return
     */
    @PostMapping(value = "/register")
    @ResponseBody
    public UserInfoVO addAddress(@RequestBody RegisterInfo registerInfo) throws Exception {
        return userService.addUser(registerInfo);

    }
}
