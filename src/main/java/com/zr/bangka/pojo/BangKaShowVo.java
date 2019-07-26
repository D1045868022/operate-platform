package com.zr.bangka.pojo;


import lombok.Data;

@Data
public class BangKaShowVo {


    private  String customerName;//客户名称

    private  String phone;//预留手机号

    private  String bankCard;//银行卡号

    private  Integer bankCardType;//银行卡类型

    private Boolean cardStatus;//卡状态

    private  String cardStatusName;//卡状态名字

    private Integer yanZhengStatus;//验证状态

    private  String yanZhengStatusName;//验证状态名字



}















