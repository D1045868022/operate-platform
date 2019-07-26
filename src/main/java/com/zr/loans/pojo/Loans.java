package com.zr.loans.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 16:34
 */
@Data
public class Loans {

    private Integer loginId;//登录loginid
    private Integer payOffStatus;//是否已经还完的状态
    private Integer amountSettlements;//结款金额
    private String paymentAccount;//收款账户
    private String startTime;//起止时间
    private String firstPayMentDate;//首次还款日
    private String name;//客户姓名
    private String idCode;//身份证号
    private String payMentDate;//还款日
    private Integer paymentCycle;//借款期限
    private String backBank;//默认还款银行
    private String agreement;//授权协议
    private Integer myCourse;//我的课程——借款用途
    private String orderNum;//订单号
    private Integer status;//16个状态
    private String createName;//创建人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;//创建时间
    private String updateName;//修改人
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;//修改时间
    private Double refundAmount;//退还金额
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loansTime;//放款时间
    private Integer pushStatus;//推送状态
    private Integer managementStatus;//推送状态
    private Integer loanType;//贷款类型
    private String managementNum;//资方申请编号
    private Double periodicContributions;//期供款
    private Integer contactNumber;//联系电话
    private Date letterTrialTime;//信审日期
    private Double capitalNum;//资方放款金额

}
