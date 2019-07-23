package com.zr.loans.pojo;

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

    private Integer id;
    private Double InteractionLoanAmount;//互动放款金额
    private Integer applyAmount;//申请金额
    private Integer applyTerm;//申请期限
    private Integer incomingPartsChannel;//进件渠道
    private String createName;//创建人
    private Date createTime;//创建时间
    private String idCode;//身份证号
    private Double managementLoanAmount;//资方放款金额
    private String merchant;//商户
    private String name;//客户姓名
    private Integer oldNumber;//订单编号
    private Double periodicContributions;//期供款
    private Integer phone;//电话
    private Integer management;//资方
    private Integer status;//资方状态 已放款、已拒绝、打款失败
    private String statusName;//资方状态 已放款、已拒绝、打款失败
    private String managementNum;//资方申请编号
    private Integer loanFishStatus;//贷鱼状态
    private Integer contactNumber;//联系电话
    private Date incomingPartsTime;//进件时间
    private Integer signatureStatus;//签章状态
    private Date letterTrialTime;//信审日期
    private String updateName;//修改人
    private Date updateTime;//修改时间
    private Date loansTime;//放款时间
    private Integer pushStatus;//推送状态
    private Integer managementStatus;//推送状态
    private Integer loanType;//贷款类型
}
