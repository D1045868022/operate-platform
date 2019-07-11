package com.zr.loan.meju;

/**
 * @authot 谢烽
 * @create 2019 - 07 - 03 - 23:40
 */
public enum LivingConditionsEnum {

        DANZU("单租",0),HEZU("合租",1),YOUFANG("有房",2);
    private final String LivingConditionsName;
    private final Integer LivingConditionsValue;

    private LivingConditionsEnum(String LivingConditionsName, Integer LivingConditionsValue)
    {
        this.LivingConditionsName = LivingConditionsName;
        this.LivingConditionsValue = LivingConditionsValue;
    }
    // 通过值去名称
    public static String getName(int subjectValue) {
        for (LivingConditionsEnum c : LivingConditionsEnum.values()) {
            if (c.getLivingConditionsValue() == subjectValue) {
                return c.LivingConditionsName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String subjectName) {
        for (LivingConditionsEnum c : LivingConditionsEnum.values()) {
            if (c.getLivingConditionsName().equals(subjectName)) {
                return c.LivingConditionsValue;
            }
        }
        return null;
    }

    public String getLivingConditionsName() {
        return LivingConditionsName;
    }

    public Integer getLivingConditionsValue() {
        return LivingConditionsValue;
    }
}
