package com.zr.meiju;

/**
 * 订单状态枚举
 */

public enum OrderNumEnum {
    TIQIANJIEQING("提前结清",0),
    TUIHUO("退课",1);

    private final String statusName;
    private final Integer statusValue;

    private OrderNumEnum(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 普通方法
    public static String getName(int statusValue) {
        for (OrderNumEnum c : OrderNumEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (OrderNumEnum c : OrderNumEnum.values()) {
            if (c.getStatusName().equals(statusName)) {
                return c.getStatusValue();
            }
        }
        return null;
    }
//    public String getStatusName() {
//        return statusName;
//    }

    public String getStatusName() {
        return statusName;
    }

    public Integer getStatusValue() {
        return statusValue;
    }
}
