package com.zhouyunji.controller;

import com.zhouyunji.bean.FormData;
import com.zhouyunji.common.Model;
import com.zhouyunji.util.PathUtil;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;

@Controller()
@RequestMapping("/pic")
public class PicController {
    @RequestMapping(value = "/main", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] main(FormData formData, HttpSession session, HttpServletResponse response) {

        String classPath = PathUtil.getClassPath();
        File file = new File(classPath + "/recycle/main.png");
        FileInputStream inputStream = null;
        byte[] bytes = null;
        try {
            inputStream = new FileInputStream(file);
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("main图片读取错误");
        }
        return bytes;

    }
}
