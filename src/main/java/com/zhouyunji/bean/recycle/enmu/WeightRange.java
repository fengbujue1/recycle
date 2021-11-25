package com.zhouyunji.bean.recycle.enmu;

public enum WeightRange {
    RANGE1(0),//1~25公斤
    RANGE2(1),//25~50公斤
    RANGE3(2),//50~250公斤
    RANGE4(3);//250公斤以上
    private int rangeCode;

    WeightRange(int rangeCode) {
        this.rangeCode = rangeCode;
    }
    public static WeightRange getWeightRangeByRangeCode(int rangeCode) {
        switch (rangeCode) {
            case 1:
                return WeightRange.RANGE1;
            case 2:
                return WeightRange.RANGE2;
            case 3:
                return WeightRange.RANGE3;
            case 4:
                return WeightRange.RANGE4;
        }
        throw new RuntimeException("错误的重量区间");
    }
    public int getRangeCode() {
        return rangeCode;
    }

    public static String getWeightRangeStrByRangeCode(int rangeCode) {
        switch (rangeCode) {
            case 0:
                return "0~25公斤";
            case 1:
                return "25~50公斤";
            case 2:
                return "50~250公斤";
            case 3:
                return "250公斤以上";
        }
        throw new RuntimeException("错误的重量区间");
    }
}
