package com.zr.meiju;

/**
 * 给扣款结果枚举
 */

public enum StatusEnum {
    SHIBAI("失败",0),
    CHENGGONG("成功",1);

    private final String statusName;
    private final Integer statusValue;

     StatusEnum(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 通过值取名称
    public static String getName(int statusValue) {
        for (StatusEnum c : StatusEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (StatusEnum c : StatusEnum.values()) {
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