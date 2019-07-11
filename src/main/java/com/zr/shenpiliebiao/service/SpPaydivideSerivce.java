package com.zr.shenpiliebiao.service;


import com.zr.shenpiliebiao.pojo.SpPaydivideSelectVo;
import com.zr.util.ResultVO;

/**
 * 待审批service接口
 * Created by 李江涛 on 2019/7/9 0009.
 */
public interface SpPaydivideSerivce {


    //分页查询
    ResultVO queryByPage(SpPaydivideSelectVo spPaydivideSelectVo);




}
