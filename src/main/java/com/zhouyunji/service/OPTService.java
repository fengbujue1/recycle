package com.zhouyunji.service;

import com.zhouyunji.bean.FormData;
import com.zhouyunji.bean.LoginData;
import com.zhouyunji.bean.MappingRelation;
import com.zhouyunji.common.Model;
import com.zhouyunji.common.SessionKeys;
import com.zhouyunji.dao.OPTMapper;
import com.zhouyunji.util.PathUtil;
import com.zhouyunji.util.QRUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@Service
public class OPTService {

    @Autowired
    OPTMapper optMapper;
    /**
     * session检查，不通过的话跳转回登陆界面,通过的话就把userId赋予FormData实例
     * @param session
     * @param response
     */
    public void checkSession(
            HttpSession session,
            HttpServletResponse response,
            FormData formData
    ) {
        Object attribute = session.getAttribute(SessionKeys.USER_ID);
        if (attribute == null) {
            // 跳转到登录页面
            try {
                response.sendRedirect("/QR/toLogin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            formData.setUserId((String) attribute);
        }
    }

    /**
     * 数据的存储，二维码的生成,文件名和存储地址的返回
     * @param formData
     */
    public Model storageData(FormData formData) {
        //数据存库
        String uuid = UUID.randomUUID().toString();
        String fileName = uuid + ".jpg";
        formData.setFileName(fileName);
        optMapper.insertData(formData);
        //生成文件名字与存储路径
        String classPath = PathUtil.getClassPath();
        String url = "http://182.92.211.22:8088/QR/getData?fileName=" + fileName;//测试的时候这里不能使用localhost作为ip
        String QRLocation = classPath + "targetPic/" + fileName;
        try {
            QRUtil.encode(url, QRLocation);
//            QRUtil.encode("http://www.baidu.com", QRLocation);
        } catch (Exception e) {
            System.out.println("二维码生成错误");
        }

        return new Model(fileName, QRLocation);

    }


    /**
     * 映射关系存库
     *
     * @param formData
     * @param model
     */
    public void storageMappingRelation(FormData formData, Model model) {

        String userId = formData.getUserId();
        MappingRelation mappingRelation = new MappingRelation();
        mappingRelation.setQRLocation(model.model2);
        mappingRelation.setFileName(model.model1);
        mappingRelation.setUserId(userId);
        optMapper.insertMappingRelation(mappingRelation);
    }

    /**
     * 返回资料
     *
     * @param fileName
     * @return
     */
    public FormData returnData(String fileName, HashMap<String, Object> map) {
        FormData formData = optMapper.selectFormData(fileName);
        map.put("client", formData.getClient());
        map.put("number", formData.getNumber());
        map.put("projectName", formData.getProjectName());
        map.put("date", formData.getDate());
        map.put("auditPerson", formData.getAuditPerson());
        map.put("result", formData.getResult());
        map.put("extraText", formData.getExtraText());
        return formData;
    }

    /**
     * 返回二维码图片
     * @param QRLocation
     * @return
     */
    public byte[] returnQR(String QRLocation) {
        File file = new File(QRLocation);
        System.out.println(file);
        FileInputStream inputStream = null;
        byte[] bytes = null;
        try {
            inputStream = new FileInputStream(file);
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, inputStream.available());
        } catch (Exception e) {
            System.out.println("\"/upload\""+"二维码返回出错");
        }
        return bytes;
    }

}
