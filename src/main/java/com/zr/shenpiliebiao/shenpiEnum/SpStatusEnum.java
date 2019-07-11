package com.zr.shenpiliebiao.shenpiEnum;

/**
 * 枚举类
 * 用于转换雪竹分期表中的status'字段
 * 0.正常状态 1.确定状态。2.取消状态 3.审核通过状态 4.审核不通过状态 5.作废
 *
 * Created by Administrator on 2019/7/9 0009.
 */
public enum SpStatusEnum {

    ZCZT("正常状态",0),QDZT("确定状态",1),QXZT("取消状态",2),SHTGZT("审核通过状态",3),
    SHBTG("审核不通过状态",4),ZF("作废",5);


    private String statusName;
    private Integer StatusValue;


    //根据值获取名字
    public static String getstatusName(Integer apartmentValue){
        for(SpStatusEnum statusEnmutatusEnmu : SpStatusEnum.values()){
            if(statusEnmutatusEnmu.getStatusValue() == apartmentValue){
                return statusEnmutatusEnmu.getStatusName();
            }
        }
        return null;
    }
    //根据名字获取值
    public static Integer getstatusValue(String apartmentName){
        for(SpStatusEnum statusEnmutatusEnmu : SpStatusEnum.values()){
            if(statusEnmutatusEnmu.getStatusName().equals(apartmentName)){
                return statusEnmutatusEnmu.getStatusValue();
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

    SpStatusEnum(String statusName, Integer statusValue) {
        this.statusName = statusName;
        StatusValue = statusValue;
    }
}
