package com.zr.yuqiliebiao.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 逾期列表
 *
 */
@Data
public class Overduelist {
    private Integer id;//	int
    private String idCode;//	varchar'身份证号'
    private String phone;//	int'手机号'
    private Integer overdueAmount;//	int'逾期金额'
    private Date createTime;//	datetime'创建时间'
    private String createName;//	varchar
    private Date updateTime;//	datetime
    private String updateName;//	varchar
    private Double penaltyInterest;//罚息
    private Double principalRepayment;//应还本金
    private Double interestPayable;//应还利息
    private String merchantName; //商户名称
    private String name;
}
