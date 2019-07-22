package com.zr.meiju;

import lombok.Getter;

/**
 * Created by 86151 on 2019/4/25.
 */
@Getter
public enum ManagementStatusEnum {
    FANGKUANSHIBAI("放款失败",0),
    FANGKUANCHENGGONG("放款成功",1);

    private final String creditStatusName;
    private final Integer creditStatusValue;


    ManagementStatusEnum(String creditStatusName, Integer creditStatusValue) {
        this.creditStatusName = creditStatusName;
        this.creditStatusValue = creditStatusValue;
    }

    // 普通方法
    public static String getName(int creditStatusValue) {
        for (ManagementStatusEnum c : ManagementStatusEnum.values()) {
            if (c.getCreditStatusValue() == creditStatusValue) {
                return c.creditStatusName;
            }
        }
        return null;
    }
    // 通过名称取值
    public static Integer getValue(String creditStatusName) {
        for (ManagementStatusEnum c : ManagementStatusEnum.values()) {
            if (c.getCreditStatusName().equals(creditStatusName)) {
                return c.creditStatusValue;
            }
        }
        return null;
    }

}
