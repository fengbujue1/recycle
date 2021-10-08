package com.zhouyunji.controller;

import com.zhouyunji.bean.FormData;
import com.zhouyunji.util.PathUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

@Controller()
@RequestMapping("/test")
public class Hello {
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/qr",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] qr() {
        String classPath = PathUtil.getClassPath();
        File file = new File(classPath + "targetPic/hello.jpg");
        System.out.println(file);
        FileInputStream inputStream = null;
        byte[] bytes = null;
        try {
            inputStream = new FileInputStream(file);
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes;
    }

    @GetMapping("/receivePararm")
    @ResponseBody
    public String receivePararm() {
        return "hello";
    }

    @RequestMapping("/show")
    public String show(HashMap<String, Object> map, Model model) {
        model.addAttribute("say","欢迎欢迎,热烈欢迎");
        map.put("hello", "欢迎进入HTML页面");
        return "show";

    }



}
