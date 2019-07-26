package com.zr.zhuanan.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;


@Data
public class ZhuanAnShowVo extends PageVo {
    private Integer id;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;    //生成时间
    private String createName;  //创建人
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateTime;    //修改时间
    private String updateName;  //修改人

}

