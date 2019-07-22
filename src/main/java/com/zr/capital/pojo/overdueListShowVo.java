package com.zr.capital.pojo;

import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

/**
 * 逾期查询显示Vo
 */
@Data
public class overdueListShowVo extends PageVo {
    private Integer id;
    private Integer riskId;
    private String idNo;//身份证号
    private String merchant;//商户
    private String customerName;//客户姓名
    private Integer phone;//手机号
    private Integer applyAmount;//申请金额
    private Integer overdueAmount;//逾期金额
    private Integer overduePrincipalInterest;//逾期本息
    private Integer overdueCost;//逾期费用
    private Integer term;//期限
    private Date lendingTime;//放款时间
    private Integer overdueDay;//逾期天数
    private Integer nowOverdueNum;//当前逾期期数
    private Date dataTime;//数据日期
    private String overdueReason;//逾期原因
    private Date createTime;//创建时间
    private String createName;
    private Date updateTime;
    private String updateName;
    private String businessType;//业务类型
    private String orderNum;//订单编号
    private Date settleTime;//结清日期
    private Date loanTime;//放款日期
    private String managemen;//`资方
    private Integer channel;//渠道
    private String idCode;//身份证号码
    private Double shenQingAmount;//申请金额
    private Double shenQingNum;//申请期数
    private Double qiGongKuan;//期供款
    private Double surplusNum;//剩余期数
    private Double yiHuanAmount;//已还款金额
    private Double zhinaAmount;//滞纳金
    private String penaltyInterest;//罚息
    private String compoundInterest;//复利
    private Double yuQiAmount;//逾期管理费
    private Integer yuQiDay;//逾期天数
    private Double yuQiPeriods;//逾期期数
    private Integer amountOfRefund_interest;//退贴息金额
    private Double interestRate;//利率
    private Double merchantTuiDaiYuAmount;//商户应退贷鱼金额
    private Double daiYuTuiZiFangAmount;//贷鱼应退资方金额
    private Double managemenLoanAmount;//资方放款金额
    private Double DaiYuLoanAmount;//贷鱼放款金额
    private Integer status;//状态

}
