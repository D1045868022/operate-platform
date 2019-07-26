package com.zr.zhuanan.pojo;


import lombok.Data;

@Data
public class ZhuanAnSelectVo {
    private String projectName	;//专案名称
    private double accountingFees;//帐管费
    private String accountingName;//帐管费名称
    private double businessDiscountRate;//商户贴息利率
    private double customerYearRate;//客户年利率
    private double quota;//额度
    private String paymentMethod;//还款方式名称
    private String  term;//期限
    private String  managementProjectCode;//资方专案代码
    private String  managementName;//资方名称
    private String profitSource	;//利润来源
    private String receiveStatus;//接收状态
}
