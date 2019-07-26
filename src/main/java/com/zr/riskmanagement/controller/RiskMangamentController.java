package com.zr.riskmanagement.controller;


import com.zr.meiju.StatusMerchant;
import com.zr.riskmanagement.pojo.RiskReserveAddVo;
import com.zr.riskmanagement.pojo.RiskReserveSelectVo;
import com.zr.riskmanagement.service.RiskMangamentService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.util.XiaLaVo;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 94818 on 2019/6/22.
 */
@RestController
public class RiskMangamentController {

    @Autowired
    private RiskMangamentService riskMangamentService;

    @PostMapping("riskMa/add")
    private ResultVO add(@RequestBody RiskReserveAddVo riskReserveAddVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOBuilder.error("500",bindingResult.getFieldError().getDefaultMessage());
        }
       return riskMangamentService.add(riskReserveAddVo);
    }


     //渠道维护下拉
    @PostMapping("riskMa/mainenancestaff")
    private ResultVO queryMainenancestaff(){
        return riskMangamentService.queryMainenancestaff();
    }


    //商户状态枚举下拉
    @PostMapping("riskMa/merchantStatus")
    public ResultVO<List<XiaLaVo>> enquiryStatus2(){
        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        for (int i = 0; i< StatusMerchant.values().length; i++){
            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(i);
            xiaLaVo.setLabel(StatusMerchant.getStatusName(i));
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }
    /**
     * 资方日报表查询功能
     */

    @PostMapping("riskMa/queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody RiskReserveSelectVo riskReserveSelectVo){
        return riskMangamentService.queryPage(riskReserveSelectVo);
    }


    @GetMapping("riskMa/queryByremeId")
    public ResultVo queryByremeId(@RequestParam("remeId") Integer remeId){
        return riskMangamentService.queryByremeId(remeId);
    }
}
