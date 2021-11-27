package com.zhouyunji.bean.recycle;

import java.util.Date;
import java.util.List;

public class RecycleOrderPo {
    private int id;
    private String orderId;//订单Id使用uuid
    private Integer userId;//用户id
    private Integer recycleType;//1:废纸 2：塑料 3：家电 4：手机
    private Date time;//为空则代表尽快上门
    private Date submitTime;//下单时间
    private int addressId;//回收地址
    private String remark;//备注留言
    private int status;//订单状态 1:未接单(初始) 2：已接单 3：已完成 4：已取消
    private boolean canceled = false;//订单是否取消

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getRecycleType() {
        return recycleType;
    }

    public void setRecycleType(Integer recycleType) {
        this.recycleType = recycleType;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
