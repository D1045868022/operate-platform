package com.zr.loan.meju;

/**婚姻状态下拉框
 * @authot 谢烽
 * @create 2019 - 07 - 03 - 23:40
 */
public enum MaritalStatusEnum {

        YIHUN("已婚",0),WEIHUN("未婚",1);
    private final String maritalStatustName;
    private final Integer maritalStatustValue;

    private MaritalStatusEnum(String maritalStatustName, Integer maritalStatustValue)
    {
        this.maritalStatustName = maritalStatustName;
        this.maritalStatustValue = maritalStatustValue;
    }
    // 通过值去名称
    public static String getName(int subjectValue) {
        for (MaritalStatusEnum c : MaritalStatusEnum.values()) {
            if (c.getMaritalStatustValue() == subjectValue) {
                return c.maritalStatustName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String subjectName) {
        for (MaritalStatusEnum c : MaritalStatusEnum.values()) {
            if (c.getMaritalStatustName().equals(subjectName)) {
                return c.maritalStatustValue;
            }
        }
        return null;
    }

    public String getMaritalStatustName() {
        return maritalStatustName;
    }

    public Integer getMaritalStatustValue() {
        return maritalStatustValue;
    }
}
