package com.zhouyunji.bean.address;

public class Address {
    private String id;//地址唯一id
    private String token;//用户token
    private String name;//联系人姓名
    private String phoneNo;//联系电话
    private String town;//街道/乡镇
    private String districtCode;//区级码
//    private String house;//小区
    private String detail;//详细地址（楼 栋 单元）
    private String openid;//唯一id

    private boolean isDefault;//是否默认地址

    public boolean isDefault() {
        return isDefault;
    }

    public void setIsDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    //    public String getHouse() {
//        return house;
//    }
//
//    public void setHouse(String house) {
//        this.house = house;
//    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }
}
