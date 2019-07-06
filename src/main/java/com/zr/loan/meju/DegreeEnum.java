package com.zr.loan.meju;

/**
 * 婚姻状态下拉框
 *
 * @authot 谢烽
 * @create 2019 - 07 - 03 - 23:40
 */
public enum DegreeEnum {

    CHUZHONGJIYIXIA("初中及以下", 0), GAOZHONG("高中", 1), ZHONGZHUAN("中专", 2), DAZHUAN("大专", 3),BENKE("本科",4),SHUOSHI("硕士",5),BOSHI("博士",6);
    private final String DegreeName;
    private final Integer DegreeValue;

    public String getDegreeName() {
        return DegreeName;
    }

    public Integer getDegreeValue() {
        return DegreeValue;
    }

    DegreeEnum(String degreeName, Integer degreeValue) {
        DegreeName = degreeName;
        DegreeValue = degreeValue;
    }

    // 通过值去名称
    public static String getName(int DegreeValue) {
        for (DegreeEnum c : DegreeEnum.values()) {
            if (c.getDegreeValue() == DegreeValue) {
                return c.DegreeName;
            }
        }
        return null;
    }

    // 通过名称取值
    public static Integer getValue(String DegreeName) {
        for (DegreeEnum c : DegreeEnum.values()) {
            if (c.getDegreeName().equals(DegreeName)) {
                return c.DegreeValue;
            }
        }
        return null;
    }


}
