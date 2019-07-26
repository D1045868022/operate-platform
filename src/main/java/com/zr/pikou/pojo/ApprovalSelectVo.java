package com.zr.pikou.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

/**
 批扣列表查询Vo
 */
@Data
public class ApprovalSelectVo extends PageVo {

        private String loanContractNum;//贷款合同号

        private String customerName;//客户姓名

        private String idCode;//证件号

        private double deductible;//应扣款

        private Integer reimbursementAccountOpeningBank;//还款账户开户行

        private String paymentAccount;//还款银行账号

        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
        private Date createTime;    //生成时间

        @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
        private Date issuanceOfWithholdingTime;//发出代扣时间  代扣日期

        private Boolean deductionResults;//扣款结果

        private String statusName;//扣款结果名称

        private String approvalChannel;//批扣渠道

        private Integer isApproval;//是否可批扣

        private String deductionStatus;//扣款失败原因

        private Integer status;

}


