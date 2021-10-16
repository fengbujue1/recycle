package com.zhouyunji.bean.recycle;

import com.zhouyunji.bean.recycle.enmu.HeightRange;
import com.zhouyunji.bean.recycle.enmu.RecycleKindByType;

public class RecycleItem {
    private String orderId;
    private int recycleKind;
    private int heightRange;

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

    public int getHeightRange() {
        return heightRange;
    }

    public void setHeightRange(int heightRange) {
        this.heightRange = heightRange;
    }

//    public HeightRange getHeightRangeEnum() {
//        return HeightRange.getHeightRangeByRangeCode(heightRange);
//    }
//    public RecycleKindByType getRecycleKindEnum(int recycleKind) {
//        return RecycleKindByType.getRecycleTypeByCode(recycleKind);
//    }

}
