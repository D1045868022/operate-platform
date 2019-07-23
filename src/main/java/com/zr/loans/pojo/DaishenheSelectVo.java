package com.zr.loans.pojo;

import com.zr.util.PageVo;
import lombok.Data;

@Data
public class DaishenheSelectVo extends PageVo {
    private Integer LoanType;//货款类型：
    private String LoanTypeName;//货款类型名称
    private String name;//客户姓名：
    private Integer incomingPartsChannel;//渠道名称：
    private Integer incomingPartsChannelName;//渠道名称
    private Integer management;//资方名称：
    private Integer status;//订单状态：
}
