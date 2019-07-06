package com.zr.loan.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

/**
 *
 * mhh
 * 贷款情况查询,查询vo
 */
@Data
public class LoanSelectVo extends PageVo {
    private String idNo;    //身份证号
    private String idName;    //姓名
    private String phoneNo;    //联系电话
    private String bcName;    //商户名称
    private Integer fundSource;    //资方
    private Integer hdStatus; //贷鱼贷款状态
    private Integer pushStatus; //推送状态
    private Integer sourceType; //贷鱼贷款状态
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date applyDateStart1; //进件时间(开始)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date applyDateStart2; //进件时间(结束)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private  Date applyDateStart3;  //信审日期(开始)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private  Date applyDateStart4;  //信审日期(结束)
    private String bobApplyCode;   //资方申请编号
    private String siginStatus;    //签章状态
}
