package com.zr.daishenpi.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.util.PageVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;

/**
 * 根据前端页面筛选出来的字段 对表---paydivide  进行部分查询
 * Created by 李江涛 on 2019/7/9 0009.
 */
@Data
public class PaydivideSelectVo extends PageVo{

    private Integer Id;
/*    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;//开始时间 （进件时间）*/
    private String name; //客户姓名
    private Integer status; //推送状态 value
    private String statusName; // 推送状态 name


}
