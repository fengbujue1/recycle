package com.zhouyunji.bean.user;

/**
 * 返回给前端展示的用户信息
 */
public class UserInfoVO {
    private String token;//token
    private String nickname;//昵称
    private String img;//头像
    private String isSupplement;//是否补充（用户是否点击过授权获取用户信息）


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public String getIsSupplement() {
        return isSupplement;
    }

    public void setIsSupplement(String isSupplement) {
        this.isSupplement = isSupplement;
    }
}
