package com.zhouyunji.bean.recycle.enmu;

public enum OrderStatus {
    NOT_ACCEPT(1),//初始状态 未接单
    ACCEPTED(2),//已接单
    FINISHED(3),//已完成
    CANCLED(4);//已取消

    private int statusCode;

    /**
     * 即使不声明为private的，我们也只能在enum内部使用构造器创建实例
     * 定义结束后，编译器就不会允许我们在任何地方使用enum的构造器创建任何实例了
     * @param statusCode
     */
    private OrderStatus(int statusCode) {
        this.statusCode = statusCode;
    }
    public int statusCode() {
        return statusCode;
    }
    public static OrderStatus getStatusByCode(int statusCode) {
        switch (statusCode) {
            case 1:
                return OrderStatus.NOT_ACCEPT;
            case 2:
                return OrderStatus.ACCEPTED;
            case 3:
                return OrderStatus.FINISHED;
            case 4:
                return OrderStatus.CANCLED;
        }
        throw new RuntimeException("错误的订单状态");
    }

}
