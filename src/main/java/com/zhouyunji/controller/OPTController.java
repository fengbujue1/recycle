package com.zhouyunji.controller;

import com.zhouyunji.bean.FormData;
import com.zhouyunji.common.Model;
import com.zhouyunji.common.SessionKeys;
import com.zhouyunji.service.OPTService;
import com.zhouyunji.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

@Controller()
public class OPTController {
    @Autowired
    OPTService optService;


    @RequestMapping(value = "/upload", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] upload(FormData formData, HttpSession session, HttpServletResponse response) {

        System.out.println(formData);

        //session检查
        optService.checkSession(session, response, formData);
        //文件资料存库,二维码的生成
        Model model = optService.storageData(formData);
        //映射关系存库
        optService.storageMappingRelation(formData, model);
        //返回二维码图片
        return optService.returnQR(model.model2);

    }

    /**
     * 方法返回资料
     *
     * @return
     */
    @RequestMapping(value = "/getData")
    public String getData(@RequestParam(value = "fileName", required = false) String fileName, HashMap<String, Object> map) {
        System.out.println(fileName);
        optService.returnData(fileName,map);
        return "show";
    }
}
