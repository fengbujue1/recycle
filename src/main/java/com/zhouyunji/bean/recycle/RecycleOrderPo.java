package com.zhouyunji.bean.recycle;

import java.util.List;

public class RecycleOrderPo {
    private Integer id;
    private Integer userId;//用户id
    private Integer recycleType;//1:废纸 2：塑料 3：家电 4：手机
    private String time;//为空则代表尽快上门
    private int addressId;//回收地址
    private String remark;//备注留言

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecycleType() {
        return recycleType;
    }

    public void setRecycleType(Integer recycleType) {
        this.recycleType = recycleType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
