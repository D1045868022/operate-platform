package com.zr.shenpiliebiao.pojo;

import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

/**
 * 我的审批列表 查询
 * 根据前端页面筛选出来的字段 对表---paydivide  进行部分查询
 * Created by 李江涛 on 2019/7/9 0009.
 */
@Data
public class SpPaydivideSelectVo extends PageVo{

    private Integer Id;
    private Date startTime;//开始时间 （进件时间）
    private String name; //客户姓名


}
