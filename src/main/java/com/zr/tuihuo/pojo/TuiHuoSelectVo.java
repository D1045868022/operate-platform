package com.zr.tuihuo.pojo;


import com.zr.util.PageVo;
import lombok.Data;


@Data
public class TuiHuoSelectVo extends PageVo {

    private String paymentAccount;//收款账户==商户名称

    private String name;//还款人==客户名称

    private Integer status;//状态

    private String statusName;//状态名称


}
