package com.zr.loan.meju;

/**
 * @authot 谢烽
 * @create 2019 - 07 - 03 - 23:40
 */
public enum YearsEnum {

            THREEMONTHS("三个月",0),SIXMONTHS("六个月",1),ONEYEAR("一年",2),TWOYEAR("两年",3);
    private final String dateTimeName;
    private final Integer dateTimeValue;

    public String getDateTimeName() {
        return dateTimeName;
    }

    public Integer getDateTimeValue() {
        return dateTimeValue;
    }

    YearsEnum(String dateTimeName, Integer dateTimeValue) {
        this.dateTimeName = dateTimeName;
        this.dateTimeValue = dateTimeValue;
    }

    // 通过值去名称
    public static String getName(int dateTimeValue) {
        for (YearsEnum c : YearsEnum.values()) {
            if (c.getDateTimeValue() == dateTimeValue) {
                return c.dateTimeName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String dateTimeValue) {
        for (YearsEnum c : YearsEnum.values()) {
            if (c.getDateTimeName().equals(dateTimeValue)) {
                return c.dateTimeValue;
            }
        }
        return null;
    }


}
