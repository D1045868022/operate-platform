package com.zr.meiju;

import lombok.Getter;

/**
 * 状态枚举，对应各自的状态
 * 正常状态0
 * 填写完机构确认 1  机构取消2              取消可以修改
 * 运营后台审核  审核成功3  审核不成功4  打回为5       5修改  4为作废
 * 银行审核 审核通过 6 审核不通过7    审核不通过作废
 * 银行签约 签约通过 8 签约不通过9   签约不通过作废
 * 银行放款  放款成功10  放款不成功11   ？
 * 学生还款 还款中为12  已还完13    已还完改每个表中的payoffStatus为已还完
 * 逾期状态 14
 * 提前还清状态 15     改每个表中的payoffStatus为已还完
 * 退款状态 16        改每个表中的payoffstatus为退款状态
 */
@Getter
public enum TuiHuoEnum {
    ZHENGCHANGZHUANGTAI("正常状态",0),
    JIGOUQUEREN("机构确认",1),
    JIGOUQUXIAO("机构取消",2),
    SHENHECHENGGONG("审核成功",3),
    SHENHEBUCHENGGONG("审核不成功",4),
    DAHUI("打回",5),
    SHENHETONGGUO("审核通过",6),
    SHENHEBUTONGGUO("审核不通过",7),
    QIANYUETONGGUO("签约通过",8),
    QIANYUEBUTONGGUO("签约不通过",9),
    FANGKUANCHENGGONG("放款成功",10),
    FANGKUANBUCHNEGGONG("放款不成功",11),
    HUNAKUANZHONG("放款中",12),
    YIHUANWAN("已还完",13),
    YUQIZHUANGTAI("逾期状态",14),
    TIQIANHUANQINGZHUANGTAI("提前还清状态",15),
    TUIKUANZHUANGTAI("退款状态",16);


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

    TuiHuoEnum(String statusName, Integer statusValue) {
        this.statusName = statusName;
        StatusValue = statusValue;
    }

}
