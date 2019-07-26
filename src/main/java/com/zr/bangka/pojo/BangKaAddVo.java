package com.zr.bangka.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BangKaAddVo implements Serializable {


    @NotBlank(message = "客户名称不能为空！")
    private  String name;//客户名称

    @NotBlank(message = "身份证号不能为空！")
    private String idCode;//身份证号

    @NotBlank(message = "银行卡账号不能为空！")
    private  String bankCardAccount;//银行卡号

    @NotNull(message = "开户行不能为空！")
    private  Integer openingBank;//银行卡类型

    @NotBlank(message = "预留手机号不能为空！")
    private  String bankPhone;//预留手机号


}

