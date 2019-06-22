package com.zr.lendinglist.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

/**
 * Created by Administrator on 2019/6/21.
 */
@Data
public class LendingListSelectVo extends PageVo{

    private Integer fundingParty;//'资金方'

    private String merchant;//'商户'

    private String customerName;//'客户姓名'

    private Integer idCode;//'身份证号码'

    private Double applyAmount;//'申请金额'

    private Integer applyTerm;//'申请期限'

    private Integer discountMode;//'贴息方式'

    private Integer periodicContributions;//'期供款'

    private Double managementLoanAmount;//'资方放款金额'

    private Double daiyuLoanAmount;//'贷鱼放款金额'

    private Integer loanStatus;//'贷款状态'

    private Integer graceperiod;//宽限期

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date applyTime;//'申 请 时 间'

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date examineTime;//'审请通过时间'

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date lendingTime;//'放款日期'

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
    private Date typeTime;

}
