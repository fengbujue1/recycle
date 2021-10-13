package com.zhouyunji.bean.recycle;

import com.zhouyunji.bean.recycle.enmu.HeightRange;
import com.zhouyunji.bean.recycle.enmu.RecycleKindByType;

public class RecycleItem {
    private int recycleKind;
    private int heightRange;

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

    public HeightRange getHeightRangeEnum() {
        return HeightRange.getHeightRangeByRangeCode(heightRange);
    }
    public RecycleKindByType setRecycleKindEnum(int recycleKind) {
        return RecycleKindByType.getRecycleTypeByCode(recycleKind);
    }

}
