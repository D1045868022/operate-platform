package com.zr.daishenpi.service;

import com.zr.daishenpi.pojo.PaydivideSelectVo;
import com.zr.daishenpi.pojo.PaydivideUpdateStatusVo;
import com.zr.util.ResultVO;

/**
 * 待审批service接口
 * Created by 李江涛 on 2019/7/9 0009.
 */
public interface PaydivideSerivce {


    //分页查询
    ResultVO queryByPage(PaydivideSelectVo paydivideSelectVo);

    //修改审批状态
    ResultVO updateStatus(PaydivideUpdateStatusVo paydivideUpdateStatusVo);
}
