package com.zhouyunji.dao;

import com.zhouyunji.bean.user.UserInfoPo;

public interface UserDao {
    public void addUser(String openId);

    /**
     * 补全用户信息
     * @param openId
     */
    public void supplementUserInfo(String openId);

    public UserInfoPo getUser(String openId);
}
