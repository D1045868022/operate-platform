package com.zr.mechant.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class Mechant_Configure {
    private Integer id;
    private  String landingAccount;
    private String landingPassword;
    private  Integer type;
    private Integer isStore;
    private Integer isCreateStore;
    private Integer  isDeduction;
    private  Integer isGrantAuthorization;
    private Integer isActiveRepayment;
    private Integer education;
    private Integer renting;
    private Integer digital;
    private Integer blueWaterSource;
    private Integer huaBei;
    private  Integer monthlyRentPayment;
    private Integer medicalBeauty;
    private Integer  channelMaintenance;
    private  Integer apartmentType;
    private Integer isAddHousingResources;
    private  Integer  mechanismType;
    private Integer mechantId;//外键
    private String mechantaccount;//商户登录账号
    private String mechantpassword;//商户登录密码


}
