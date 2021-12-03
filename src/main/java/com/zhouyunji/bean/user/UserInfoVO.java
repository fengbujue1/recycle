package com.zhouyunji.bean.user;

/**
 * 返回给前端展示的用户信息
 */
public class UserInfoVO {
    private String token;//token
    private String nickname;//昵称
    private String img;//头像
    private Boolean isSupplement=false;//是否补充（用户是否点击过授权获取用户信息）


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

    public Boolean getSupplement() {
        return isSupplement;
    }

    public void setSupplement(Boolean supplement) {
        isSupplement = supplement;
    }

    public void setImg(String img) {

        this.img = img;
    }

}
