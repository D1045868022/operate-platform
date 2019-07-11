package com.zr.riskmanagement.pojo;

import com.zr.util.PageVo;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by 94818 on 2019/6/22.
 */
@Data
public class RiskReserveSelectVo extends PageVo{//基本信息表
    private String merchantName;//风险准备金系数
    private Integer  id;//渠道维护
    private Integer key;//业务类型
    private Integer status;//商户状态
}
