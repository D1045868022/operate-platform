package com.zr.daishenpi.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2019/7/9 0009.
 */
@Data
public class PaydivideUpdateStatusVo {

    @NotNull(message = "id不能为空！")
    private Integer id;
    @NotNull(message = "状态不能为空！")
    private Integer status;


}
