package com.zhouyunji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
public class Index {
    @RequestMapping("/")
    public String upload() {
        return "home";
    }
}
