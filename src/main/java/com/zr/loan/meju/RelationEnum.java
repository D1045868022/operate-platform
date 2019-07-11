package com.zr.loan.meju;

/**
 * Created by 86151 on 2019/4/25.
 */

public enum RelationEnum {//和我的关系
    fuzi("父子",0),muzi("母子",1),ziqi("妻子",2),jiedi("兄弟姐弟",3),yesun("爷孙",4),pengyou("朋友",5),tongshi("同事",6);

    private final String statusName;
    private final Integer statusValue;

    private RelationEnum(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 通过值去名称
    public static String getName(int statusValue) {
        for (RelationEnum c : RelationEnum.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String statusName) {
        for (RelationEnum c : RelationEnum.values()) {
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
