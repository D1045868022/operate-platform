package com.zr.capital.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 签约成功发送签约成功信息给运营平台,接收信息Vo
 */
@Data
public class SignContractVo {

//    @NotBlank(message = "身份证号码不能为空能够")
    private String idCard;//身份证号码

//    @NotNull(message = "签约状态不能为空能够")
    private Boolean status;//签约状态

}
