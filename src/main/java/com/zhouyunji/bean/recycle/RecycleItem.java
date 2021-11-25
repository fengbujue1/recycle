package com.zhouyunji.bean.recycle;


public class RecycleItem {
    private String orderId;
    private int recycleKind;
    private int weightRange;
    private String recycleKindStr;
    private String weightRangeStr;

    public String getRecycleKindStr() {
        return recycleKindStr;
    }

    public void setRecycleKindStr(String recycleKindStr) {
        this.recycleKindStr = recycleKindStr;
    }

    public String getWeightRangeStr() {
        return weightRangeStr;
    }

    public void setWeightRangeStr(String weightRangeStr) {
        this.weightRangeStr = weightRangeStr;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getRecycleKind() {
        return recycleKind;
    }

    public void setRecycleKind(int recycleKind) {
        this.recycleKind = recycleKind;
    }

    public int getWeightRange() {
        return weightRange;
    }

    public void setWeightRange(int weightRange) {
        this.weightRange = weightRange;
    }

//    public HeightRange getHeightRangeEnum() {
//        return HeightRange.getHeightRangeByRangeCode(heightRange);
//    }
//    public RecycleKindByType getRecycleKindEnum(int recycleKind) {
//        return RecycleKindByType.getRecycleTypeByCode(recycleKind);
//    }

}
