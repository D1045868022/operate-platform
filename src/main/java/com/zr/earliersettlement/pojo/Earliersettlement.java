package com.zr.earliersettlement.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 提前结清列表  对应表earliersettlement
 */

@Data
public class Earliersettlement {

    private Integer id;//提前结清Id

    private Double  shenQingAmount;// 结清金额

    private String  orderNum; //银行订单号

    private String  idCode; //身份证号码

    private String phone;//手机号

    private Double  serviceCharge;// 手续费

    private Double  penaltyInterest;// 罚息

    private Boolean orderStatus;//订单状态(退课或者提前结清)

    private String orderStatusName;//订单状态名称

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime; //创建时间

    private String  createName;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;

    private String  updateName;

    private Integer businessType;

}












