package com.zr.meiju;

/**
 *验证状态枚举
 */
public enum YanZhengEnum {
    WEITONGGUO("验证通过",0),
    TONGGUO("验证未通过",1),
    WEIYANZHENG("未验证",1);

    private final String statusName;
    private final Integer statusValue;

     YanZhengEnum(String statusName, Integer statusValue){
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 普通方法
    public static String getName(int statusValue) {
        for (YanZhengEnum c : YanZhengEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (YanZhengEnum c : YanZhengEnum.values()) {
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
