package com.zr.loans.meiju;

import com.zr.util.StatusEnum;
import lombok.Getter;

@Getter
public enum CapitalStatusEnum {
    YIFANGKUAN("已放款",0),DAKUANSHIBAI("打款失败",1);
    private String statusName;
    private Integer StatusValue;


    //根据值获取名字
    public static String getstatusName(Integer apartmentValue){
        for(CapitalStatusEnum capitalStatusEnum : CapitalStatusEnum.values()){
            if(capitalStatusEnum.getStatusValue() == apartmentValue){
                return capitalStatusEnum.getStatusName();
            }
        }
        return null;
    }
    //根据名字获取值
    public static Integer getstatusValue(String apartmentName){
        for(CapitalStatusEnum capitalStatusEnum : CapitalStatusEnum.values()){
            if(capitalStatusEnum.getStatusName().equals(apartmentName)){
                return capitalStatusEnum.getStatusValue();
            }
        }
        return null;
    }

    CapitalStatusEnum(String statusName, Integer statusValue) {
        this.statusName = statusName;
        StatusValue = statusValue;
    }
}
