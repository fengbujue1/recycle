package com.zhouyunji.dao;

import com.zhouyunji.bean.user.UserInfoPo;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserDao {
    public void addUser(String openId);

    public void updateUser(Long openId);

    /**
     * 补全用户信息
     * @param user
     */
    public void supplementUserInfo(UserInfoPo user);

    public UserInfoPo getUser(String openId);
}
