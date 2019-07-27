package com.zr.mechant.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/4.
 */
@Data
public class MechantInfo  {
    private Integer id;
    private  String merchantName;//商户名称
    private  String merchantLegalPerson;//商户法人
    private String  merchantAddress;//商户地址
    private String  merchantDesc;//商户简介
    private String  phone;//联系电话
    private Integer businessType;//业务类型
    private String businessTypeName;//业务类型
    private Integer isornocontract;//是否有合同
    private String isornocontractName;//是否有合同
    private Integer maintenancestaff;//维护渠道
    private String maintenancestaffName;//维护渠道
    private Integer setlimitMoney;//设置上限金额
    private Integer mechantInvitationcode;//商户邀请码
    private Integer status;//商户状态
    private String statusName;//商户状态


}
