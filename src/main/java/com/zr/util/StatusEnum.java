package com.zr.util;

import lombok.Getter;

/**
 * 状态枚举，对应各自的状态
 */
@Getter
public enum StatusEnum {
    ZHENGCHANGZHUANGTAI("正常状态",0),
    JIGOUQUEREN("正常状态",1),
    JIGOUQUXIAO("正常状态",2),
    SHENHECHENGGONG("正常状态",3),
    SHENHEBUCHENGGONG("正常状态",4),
    DAHUI("正常状态",5),
    SHENHETONGGUO("正常状态",6),
    SHENHEBUTONGGUO("正常状态",7),
    QIANYUETONGGUO("正常状态",8),
    QIANYUEBUTONGGUO("正常状态",9),
    FANGKUANCHENGGONG("正常状态",10),
    FANGKUANBUCHNEGGONG("正常状态",11),
    HUNAKUANZHONG("正常状态",12),
    YIHUANWAN("正常状态",13),
    YUQIZHUANGTAI("正常状态",14),
    TIQIANHUANQINGZHUANGTAI("正常状态",15),
    TUIKUANZHUANGTAI("正常状态",16);


    private String statusName;
    private Integer StatusValue;


    //根据值获取名字
    public static String getstatusName(Integer apartmentValue){
        for(StatusEnum statusEnum : StatusEnum.values()){
            if(statusEnum.getStatusValue() == apartmentValue){
                return statusEnum.getStatusName();
            }
        }
        return null;
    }
    //根据名字获取值
    public static Integer getstatusValue(String apartmentName){
        for(StatusEnum statusEnum : StatusEnum.values()){
            if(statusEnum.getStatusName().equals(apartmentName)){
                return statusEnum.getStatusValue();
            }
        }
        return null;
    }



    public String getStatusName() {
        return statusName;
    }

    public Integer getStatusValue() {
        return StatusValue;
    }

    StatusEnum(String statusName, Integer statusValue) {
        this.statusName = statusName;
        StatusValue = statusValue;
    }

}
