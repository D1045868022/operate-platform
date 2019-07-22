package com.zr.capital.pojo;

import lombok.Data;

/**
 * 放款后发送放款金额、订单号、资方状态给运营平台，结束数据Vo
 */
@Data
public class TobelentListVo {

    private String orderNumber;//资方订单号
    private Double managementLoanAmount;//放款金额
    private String status;//资方状态
    private Integer managementStatus;//资方状态
    private String idCode;//资方状态

}
