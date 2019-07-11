package com.zr.daishenpi.controller;

import com.zr.daishenpi.pojo.PaydivideSelectVo;
import com.zr.daishenpi.pojo.PaydivideUpdateStatusVo;
import com.zr.daishenpi.service.PaydivideSerivce;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 待审批列表    对应数据库表---paydivide
 * Created by 李江涛 on 2019/7/9 0009.
 */
@RestController
@RequestMapping("daishenpi/")
public class PaydivideController {

    @Autowired
    private PaydivideSerivce paydivideSerivce;

    /**
     * 分页查询数据库 paydivide 表中的数据
     * 条件：雪竹分期表中 status 字段状态为1，3，4，5时候才能在查询出来
     */
    @PostMapping("getUserContactsInfo")
    public ResultVO queryByPage(@RequestBody PaydivideSelectVo paydivideSelectVo){


        return paydivideSerivce.queryByPage(paydivideSelectVo);
    }

    /**
     * 审批接口  将状态修改成审核通过 或者不通过 或者作废
     * @return
     */
    @PostMapping("isAdopt")
    public ResultVO updateStatus(@RequestBody PaydivideUpdateStatusVo paydivideUpdateStatusVo){

        return paydivideSerivce.updateStatus(paydivideUpdateStatusVo);


    }




}
