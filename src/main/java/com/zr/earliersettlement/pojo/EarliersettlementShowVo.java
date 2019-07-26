package com.zr.earliersettlement.pojo;


import lombok.Data;

@Data
public class EarliersettlementShowVo  {

    private Double shenQingAmount;//结清金额

    private String orderNum;//银行订单号

    private String  idCode;//身份证号

    private String phone;//手机号

    private Double serviceCharge;//手续费

    private Double penaltyInterest;//罚息

    private Boolean orderStatus;//订单状态(退课或者提前结清)

    private String statusName; //状态名称


}


