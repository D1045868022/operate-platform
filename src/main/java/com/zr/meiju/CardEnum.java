package com.zr.meiju;

/**
 * 银行卡状态枚举
 */
public enum CardEnum {
    YOUXIAO("有效",0),
    ZHUXIAO("注销",1);

    private final String statusName;
    private final Integer statusValue;

     CardEnum(String statusName, Integer statusValue){
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 普通方法
    public static String getName(int statusValue) {
        for (CardEnum c : CardEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (CardEnum c : CardEnum.values()) {
            if (c.getStatusName().equals(statusName)) {
                return c.getStatusValue();
            }
        }
        return null;
    }

    public String getStatusName() {
        return statusName;
    }

    public Integer getStatusValue() {
        return statusValue;
    }
}
