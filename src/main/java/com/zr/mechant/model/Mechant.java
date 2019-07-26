package com.zr.mechant.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class Mechant {
    private Integer id;
    private String  merchantName;
    private String merchantLegalPerson;
    private String merchantAddress;
    private String merchantDesc;
    private String foreignPhone;
    private String phone;
    private Date createTime;
    private String createName;
    private Date updateTime;
    private String updateName;
    private Integer businessType;
    private String mechantInvitationcode;
    private Integer isornocontract;
    private Integer setlimitMoney;





}
