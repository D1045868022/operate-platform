package com.zr.shenpiliebiao.controller;


import com.zr.shenpiliebiao.pojo.SpPaydivideSelectVo;
import com.zr.shenpiliebiao.service.SpPaydivideSerivce;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 待审批列表    对应数据库表---paydivide
 * Created by 李江涛 on 2019/7/9 0009.
 */
@RestController
@RequestMapping("shenpi/")
public class SpPaydivideController {

    @Autowired
    private SpPaydivideSerivce paydivideSerivce;

    /**
     * 分页查询数据库 paydivide 表中的数据
     * 条件：雪竹分期表中 status 字段状态为1，3，4，5时候才能在查询出来
     */
    @PostMapping("getUserContactsInfo1")
    public ResultVO queryByPage(@RequestBody SpPaydivideSelectVo spPaydivideSelectVo){


        return paydivideSerivce.queryByPage(spPaydivideSelectVo);
    }



}
