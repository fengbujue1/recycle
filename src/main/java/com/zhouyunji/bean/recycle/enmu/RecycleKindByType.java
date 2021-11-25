package com.zhouyunji.bean.recycle.enmu;

public enum RecycleKindByType {
    MIXTURE_PAPE(0),//纯黄纸与纯花纸的混合
    YELLOW_PAPE(1),//纯黄纸
    FLOWER_PAPE(2),//纯花纸
    OTHER_PAPE(3),//杂纸
    PLASTIC_BOTTLE(4),//塑料瓶
    NORMAL_APPLIANCES(5),//家电
    NORMAL_PHONE(6);//手机

    private int typeCode;

    /**
     * 即使不声明为private的，我们也只能在enum内部使用构造器创建实例
     * 定义结束后，编译器就不会允许我们在任何地方使用enum的构造器创建任何实例了
     * @param typeCode
     */
    private RecycleKindByType(int typeCode) {
        this.typeCode = typeCode;
    }
    public int typeCode() {
        return typeCode;
    }
    public static RecycleKindByType getRecycleTypeByCode(int typeCode) {
        switch (typeCode) {
            case 1:
                return RecycleKindByType.MIXTURE_PAPE;
            case 2:
                return RecycleKindByType.YELLOW_PAPE;
            case 3:
                return RecycleKindByType.FLOWER_PAPE;
            case 4:
                return RecycleKindByType.OTHER_PAPE;
            case 5:
                return RecycleKindByType.PLASTIC_BOTTLE;
            case 6:
                return RecycleKindByType.NORMAL_APPLIANCES;
            case 7:
                return RecycleKindByType.NORMAL_PHONE;
        }
        throw new RuntimeException("错误的回收类型");
    }

    public static String getRecycleKindStrByCode(int typeCode) {
        switch (typeCode) {
            case 0:
                return "统纸（纯黄纸，纯花纸混合一块）";
            case 1:
                return "纯黄纸（如空调箱，快递箱等）";
            case 2:
                return "纯花纸（如饮料箱等）";
            case 3:
                return "杂纸";
        }
        throw new RuntimeException("错误的回收类型");
    }

}
