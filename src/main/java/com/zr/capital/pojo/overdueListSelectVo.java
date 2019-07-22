package com.zr.capital.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 逾期列表查询
 */
@Data
public class overdueListSelectVo {
    @NotNull(message = "逾期期数不能为空")
    private Integer nowOverdueNum;//逾期期数
    @NotNull(message = "天数不能为空")
    private Integer overdueDay;//天数
    @NotBlank(message = "手机号不能为空")
    private String phone;//手机号
    @NotBlank(message = "身份证号不能为空")
    private String idCode;//身份证号
    @NotNull(message = "罚息不能为空")
    private Double penaltyInterest;//罚息
    @NotNull(message = "应还本金不能为空")
    private Double principalRepayment;//应还本金
    @NotNull(message = "应还利息不能为空")
    private Double interestPayable;//应还利息
    @NotNull(message = "逾期金额不能为空")
    private Double overdueAmount;//逾期金额
    private String receiveStatus;//接收状态
}
