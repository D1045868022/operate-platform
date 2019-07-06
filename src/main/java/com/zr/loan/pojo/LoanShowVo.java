package com.zr.loan.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *
 * mhh
 * 贷款情况查询,查询vo
 */
@Data
public class LoanShowVo {
    private Integer loginId;//注册表外键
    private String merchant;    //商户
    private String name ;//借款人姓名 ------idName;    //姓名
    private String idCode;//借款人身份证号 -----idNo;
    private Integer amountSettlement;//结款金额  !!!!!!!
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date updateTime;
    private String paymentAccount;//收款账户 ------- 商户
    private String startTime;//起止时间
    private String firstPayMentDate;//首次还款日
    private String payMentDate;//还款日
    private Integer paymentCycle;//借款期限 !!!!!!!!!!
    private String paymentCycleName;//借款期限名称
    private String backBank;//默认还款银行
    private String agreement;//授权协议----默认值
    private Integer myCourse;//我的课程---借款用途---表paymentInformation---和lesson课程表 !!!!!!!!!!!!!
    private String myCourseName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date classHours;//上课时间--用于岂止日期和还款日------表paymentInformation  !!!!!!!!!!
    private String bankCardAccount;//银行卡账号---表userRepay   !!!!!!!!!
    private Integer openingBank;//开户行----表userRepay    !!!!!!!
    private String iphone;    //联系电话


}
