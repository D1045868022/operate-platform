package com.zr.loan.meju;

/**
 * Created by Administrator on 2019/7/3 0003.
 */

public enum ClassEnmu {

     KFGCS("开发工程师",0),QZGCS("全栈工程师",1);

     private final String ClName;
     private final Integer ClValue;

    ClassEnmu(String clName, Integer clValue) {
        ClName = clName;
        ClValue = clValue;
    }

    // 普通方法
    public static String getName(int clValue) {
        for (ClassEnmu c : ClassEnmu.values()) {
            if (c.getClValue() == clValue) {
                return c.ClName;
            }
        }
        return null;
    }

    public static int getValue(String clName) {
        for (ClassEnmu c : ClassEnmu.values()) {
            if (c.getClName().equals(clName)) {
                return c.ClValue;
            }
        }
        return -1;
    }



    public String getClName() {
        return ClName;
    }

    public Integer getClValue() {
        return ClValue;
    }
}
