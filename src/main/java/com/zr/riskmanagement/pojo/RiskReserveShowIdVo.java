package com.zr.riskmanagement.pojo;

import lombok.Data;

/**
 * Created by 94818 on 2019/6/22.
 */
@Data
public class RiskReserveShowIdVo {//分页显示Vo.
    private Integer id;//风险
    private Integer remeId;//商户名称id
    private String merchantName;//商户名称
    private String merchantNameShort;//商户简称
    private double riskReserve;//风险准备金
    private double lineCredit;//授信额度
    private double lineCredit3;//剩余额度
    private double lineCredit4;//贷款余额
    private double reserveCoefficient;//最新风险系数

}