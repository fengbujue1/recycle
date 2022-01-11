package com.zhouyunji.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Description:
 *
 * @author 周赟吉
 * @since 2021/12/9
 */
@Controller()
@RequestMapping("/hello")

public class HelloController {
    @GetMapping(value = "/hello")
    @ResponseBody
    @RequiresRoles("")
    public String hello() {
        return "hello";
    }


}
