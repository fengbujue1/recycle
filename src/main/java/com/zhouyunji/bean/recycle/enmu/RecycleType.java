package com.zhouyunji.bean.recycle.enmu;

public enum  RecycleType {
    WASTE_PAPE(1),//废纸
    METAL(2),//塑料
    HOME_APPLIANCES(3),//家电
    PHONE(4);//手机

    private int typeCode;

    /**
     * 即使不声明为private的，我们也只能在enum内部使用构造器创建实例
     * 定义结束后，编译器就不会允许我们在任何地方使用enum的构造器创建任何实例了
     * @param typeCode
     */
    private RecycleType(int typeCode) {
        this.typeCode = typeCode;
    }
    public int typeCode() {
        return typeCode;
    }
    public static RecycleType getRecycleTypeByCode(int typeCode) {
        switch (typeCode) {
            case 1:
                return RecycleType.WASTE_PAPE;
            case 2:
                return RecycleType.METAL;
            case 3:
                return RecycleType.HOME_APPLIANCES;
            case 4:
                return RecycleType.PHONE;
        }
        throw new RuntimeException("错误的回收类型");
    }

}
