package com.zr.loan.meju;

/**
 * Created by Administrator on 2019/7/3 0003.
 */
public enum  CycEnum {


    ERSHI("6+12个月",0), ERSHISI("6+18个月",1), SHIER("12个月",2);

    private final String sysName;
    private final Integer sysValue;

    private CycEnum(String sysName, Integer sysValue) {
        this.sysName = sysName;
        this.sysValue = sysValue;
    }

    // 通过值去名称
    public static String getName(Integer sysValue) {
        for (CycEnum c :CycEnum.values()) {
            if (c.getSysValue() == sysValue) {
                return c.sysName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String sysName) {
        for (CycEnum c :CycEnum.values()) {
            if (c.getSysName().equals(sysName)) {
                return c.getSysValue();
            }
        }
        return null;
    }

    public String getSysName() {
        return sysName;
    }

    public Integer getSysValue() {
        return sysValue;
    }
}
