package com.zr.sendrepaymentmessage.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class SendMessageSelectVo extends PageVo {

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date deliveryTime;

}