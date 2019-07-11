package com.zr.riskmanagement.pojo;

import lombok.Data;

/**
 * Created by 94818 on 2019/6/22.
 */
@Data
public class RiskReserveShowVo {//分页显示Vo.
    private Integer remeId;
    private String merchantName;
    private double riskReserve;//风险准备金
    private double lineCredit;//授信额度
    private String capitalSide;//资金方
    private double lineCredit2;//已代偿金额
    private double lineCredit3;//剩余额度
    private double lineCredit4;//贷款余额

}
