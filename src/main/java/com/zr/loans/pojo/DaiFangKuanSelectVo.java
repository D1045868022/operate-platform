package com.zr.loans.pojo;

import com.zr.util.PageVo;
import lombok.Data;

/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 16:34
 */
@Data
public class DaiFangKuanSelectVo extends PageVo {
    private String statusName;//资方状态
    private String  name;//姓名
    private Integer phone;//手机号
    private String  merchant;//商户
    private final Integer status = 8;
}
