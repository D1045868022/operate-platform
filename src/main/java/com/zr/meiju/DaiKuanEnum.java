package com.zr.meiju;

/**
 *验证状态枚举
 */
public enum DaiKuanEnum {
    JIAYUDAI("教育贷",0),
    ZHUFANGDAI("租房贷",1);

    private final String statusName;
    private final Integer statusValue;

     DaiKuanEnum(String statusName, Integer statusValue){
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 普通方法
    public static String getName(int statusValue) {
        for (DaiKuanEnum c : DaiKuanEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (DaiKuanEnum c : DaiKuanEnum.values()) {
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
