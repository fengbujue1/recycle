package com.zhouyunji.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zhouyunji.bean.user.RegisterInfo;
import com.zhouyunji.bean.user.UserInfoPo;
import com.zhouyunji.bean.user.UserInfoVO;
import com.zhouyunji.dao.UserDao;
import com.zhouyunji.util.BeanCopyUtil;
import com.zhouyunji.util.HTTPUtil;
import com.zhouyunji.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public static final String URL = "https://api.weixin.qq.com/sns/jscode2session?appid=wx5dc2f20c26c8b3c6&secret=af020c5dbd8b043c1c415d2de6c9766d&grant_type=authorization_code&js_code=";

    @Autowired
    UserDao userDao;

    /**
     * 用户注册：自动调入
     * @param code
     * @return
     */
    public UserInfoVO addUser(String code) throws Exception {
        String url = URL + code;
        String str = HTTPUtil.httpRequest(url);
        JSONObject jsonObject = JSON.parseObject(str);
        String openId = (String)jsonObject.get("openid");
        String sessionKey = (String)jsonObject.get("session_key");

        UserInfoPo user = userDao.getUser(openId);
        UserInfoVO userInfoVO = new UserInfoVO();
        if (user == null) {
            //新增入户
            userDao.addUser(openId);
            return userInfoVO;
        }
        if (user.getNickname() == null || user.getImg() == null) {
            //没有补充过信息，不返回token
            return userInfoVO;
        }

        BeanCopyUtil.copyProperties(user, userInfoVO, null);
        userInfoVO.setSupplement(true);

        String token =  TokenUtil.getToken(openId);;
        userInfoVO.setToken(token);
        return userInfoVO;
    }

    /**
     * 用户注册：手动调入
     * @param registerInfo
     * @return
     */
    public UserInfoVO addUser(RegisterInfo registerInfo) throws Exception {
        String code = registerInfo.getCode();
        String url = URL + code;
        String str = HTTPUtil.httpRequest(url);
        System.out.println(str);
        JSONObject jsonObject = JSON.parseObject(str);
        String openId = (String)jsonObject.get("openid");
        String sessionKey = (String)jsonObject.get("session_key");

        //TODO 还是要判断下注册没有
        UserInfoPo user = userDao.getUser(openId);
        UserInfoVO userInfoVO = new UserInfoVO();

        String token = TokenUtil.getToken(openId);
        userInfoVO.setToken(token);

        if (user == null) {
            //新增用户
            userDao.addUser(openId);
        }
        if (registerInfo.getNickname() != null || registerInfo.getImg() != null) {
            BeanCopyUtil.copyProperties(registerInfo, user, null);
            userDao.supplementUserInfo(user);
            BeanCopyUtil.copyProperties(user, userInfoVO, null);
            userInfoVO.setSupplement(true);
            return userInfoVO;
        }
        return userInfoVO;
    }
}
