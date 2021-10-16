package com.zhouyunji.bean.recycle.enmu;

public enum HeightRange {
    RANGE1(1),//1~25公斤
    RANGE2(2),//25~50公斤
    RANGE3(3),//50~250公斤
    RANGE4(4);//250公斤以上
    private int rangeCode;

    HeightRange(int rangeCode) {
        this.rangeCode = rangeCode;
    }
    public static HeightRange getHeightRangeByRangeCode(int rangeCode) {
        switch (rangeCode) {
            case 1:
                return HeightRange.RANGE1;
            case 2:
                return HeightRange.RANGE2;
            case 3:
                return HeightRange.RANGE3;
            case 4:
                return HeightRange.RANGE4;
        }
        throw new RuntimeException("错误的重量区间");
    }
    public int getRangeCode() {
        return rangeCode;
    }
}
