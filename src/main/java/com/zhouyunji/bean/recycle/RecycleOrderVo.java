package com.zhouyunji.bean.recycle;

import java.util.Date;
import java.util.List;

/**
 * 回收订单：用于登记一笔回收的基本信息
 */
public class RecycleOrderVo {
    //    private Integer id;
    private String orderId;//订单Id使用uuid
    private Integer userId;//用户id
    private Integer recycleType;//1:废纸 2：塑料 3：家电 4：手机
    private List<RecycleItem> items;
    private Date time;//预约时间，为空则代表尽快上门
    private String timeStr;//预约时间的字符串形式
    private Date submitTime;//下单时间
    private String submitTimeStr;//下单时间的字符串形式
    private int addressId;//回收地址
    private String addressStr;//回收地址(字符串形式)
    private String remark;//备注留言
    private int status;//订单状态 1:未接单(初始) 2：已接单 3：已完成 4：已取消


    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getSubmitTimeStr() {
        return submitTimeStr;
    }

    public void setSubmitTimeStr(String submitTimeStr) {
        this.submitTimeStr = submitTimeStr;
    }

    public String getAddressStr() {
        return addressStr;
    }

    public void setAddressStr(String addressStr) {
        this.addressStr = addressStr;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRecycleType() {
        return recycleType;
    }

    public void setRecycleType(Integer recycleType) {
        this.recycleType = recycleType;
    }

    public List<RecycleItem> getItems() {
        return items;
    }

    public void setItems(List<RecycleItem> items) {
        this.items = items;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTimeStr() {
        return timeStr;
    }

    public void setTimeStr(String timeStr) {
        this.timeStr = timeStr;
    }
}
