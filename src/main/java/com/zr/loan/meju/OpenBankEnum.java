package com.zr.loan.meju;

/**
 * Created by 86151 on 2019/4/25.
 */

public enum OpenBankEnum {//和我的关系
    jieshe("建设银行",0),gongshang("工商银行",1),nongye("农业银行",2),beijing("北京银行",3),zhongguo("中国银行",4);

    private final String statusName;
    private final Integer statusValue;

    private OpenBankEnum(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 通过值去名称
    public static String getName(int statusValue) {
        for (OpenBankEnum c : OpenBankEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (OpenBankEnum c : OpenBankEnum.values()) {
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
