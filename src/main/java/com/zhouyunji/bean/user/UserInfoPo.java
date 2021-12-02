package com.zhouyunji.bean.user;

/**
 * 持久层的用户信息
 */
public class UserInfoPo {
    private String code;//code
    private String nickname;//昵称
    private String img;//头像

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
