package com.zr.meiju;

/**
 * 银行卡枚举
 */
public enum BankCardEnum {
    GONGSHANG("工商银行",0),
    NONGYE("农业银行",1),
    YOUZHENG("邮政储蓄银行",2),
    ZHAOSHANG("招商银行",3),
    ZHONGGUO("中国银行",4);

    private final String statusName;
    private final Integer statusValue;

     BankCardEnum(String statusName, Integer statusValue){
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 普通方法
    public static String getName(int statusValue) {
        for (BankCardEnum c : BankCardEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (BankCardEnum c : BankCardEnum.values()) {
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
