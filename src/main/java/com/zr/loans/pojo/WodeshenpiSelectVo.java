package com.zr.loans.pojo;

import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class WodeshenpiSelectVo extends PageVo {
    private Integer loanType;     //    货款类型：
    private String name;     //    客户姓名：
    private String merchant;     //    商户名称：
    private Integer management;      //    资方名称：
    private Integer status;      //    订单状态：
    private Date incomingPartsTimeStart; //进件时间(开始)
    private Date incomingPartsTimeEnd; //进件时间(结束)
    private Integer selectType;      //    查询类型：仅我审批 所有人审批
}
