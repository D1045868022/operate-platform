package com.zr.loan.meju;

/**
 * 婚姻状态下拉框
 *
 * @authot 谢烽
 * @create 2019 - 07 - 03 - 23:40
 */
public enum OccupationalEnum {

    WUNONG("务农", 0), WUGONG("务工", 1), XUESHENG("学生", 2), GONGWUYUAN("公务员", 3),SHANGREN("商人",4),JIAOSHI("教师",5),YISHENG("医生",6);
    private final String OccupationalName;
    private final Integer OccupationalValue;

    public String getOccupationalName() {
        return OccupationalName;
    }

    public Integer getOccupationalValue() {
        return OccupationalValue;
    }

    OccupationalEnum(String occupationalName, Integer occupationalValue) {
        OccupationalName = occupationalName;
        OccupationalValue = occupationalValue;
    }

    // 通过值去名称
    public static String getName(int OccupationalValue) {
        for (OccupationalEnum c : OccupationalEnum.values()) {
            if (c.getOccupationalValue() == OccupationalValue) {
                return c.OccupationalName;
            }
        }
        return null;
    }

    // 通过名称取值
    public static Integer getValue(String OccupationalName) {
        for (OccupationalEnum c : OccupationalEnum.values()) {
            if (c.getOccupationalValue().equals(OccupationalName)) {
                return c.OccupationalValue;
            }
        }
        return null;
    }


}
