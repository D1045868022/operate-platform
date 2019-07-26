package com.zr.pikou.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 批扣列表 修改添加返回Vo
 */
@Data

public class ApprovalShowVo {

    private String customerName;//客户姓名

    private String loanContractNum;//贷款合同号

    private String idCode;//证件号

    private double deductible;//应扣款

    private Integer reimbursementAccountOpeningBank;//还款账户开户行

    private String paymentAccount;//还款银行账号

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date issuanceOfWithholdingTime;//发出代扣时间

    private String deductionStatus;//扣款失败原因

    private Boolean deductionResults;//扣款结果

    private Integer status;
}


