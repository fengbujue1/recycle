package com.zhouyunji.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
public class Index {
    @RequestMapping("/home")
    public String upload() {
        return "home";
    }
}
