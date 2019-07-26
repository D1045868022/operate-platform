package com.zr.bangka.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BangKaVo {

    private Integer id;// 绑卡Id

    private  String ustomerName;//客户名称

    private  String phone;//预留手机号

    private  String bankCard;//银行卡号

    private  Integer bankCardType;//银行卡类型

    private  String BankTypeName;//银行卡类型名字

    private  String idCode;//身份证号

    private Boolean cardStatus;//卡状态

    private  String cardStatusName;//卡状态名字

    private Integer yanZhengStatus;//验证状态

    private  String yanZhengStatusName;//验证状态名字

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;    //生成时间

    private String createName;  //创建人

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;    //修改时间

    private String updateName;  //修改人






}















