package com.zhouyunji.bean.user;

import java.math.BigInteger;

/**
 * 持久层的用户信息
 */
public class UserInfoPo {
    private String openid;//openid
    private String nickname;//昵称
    private String img;//头像


    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
