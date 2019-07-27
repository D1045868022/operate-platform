package com.zr.tuihuo.controller;


import com.zr.tuihuo.pojo.TuiHuoSelectVo;
import com.zr.tuihuo.pojo.TuiHuoShowVo;
import com.zr.tuihuo.service.TuiHuoService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.util.XiaLaVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class TuiHuoController {
    @Autowired
    private TuiHuoService tuiHuoService;

    /**
     * 退货分页查询
     */
    @PostMapping("/returnHandling/queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody TuiHuoSelectVo tuiHuoSelectVo) {

     return tuiHuoService.queryPage(tuiHuoSelectVo);
     }
    /**
     *发送给资方身份证号
     *监听并接收资方数据，如果有了最新的数据就发送给运营后台进行业务处理。
     *
     */

    @PostMapping("operate/queryReturnGoods")
    public ResultVO updateTuiHuo(@RequestBody TuiHuoShowVo tuiHuoShowVo){

        return tuiHuoService.updateTuiHuo(tuiHuoShowVo);

    }
/*
    */
/**
     * 状态下拉框
     *//*

    @PostMapping("returnHandling/getPullDownList")
    public ResultVO<List<XiaLaVo>> queryXiaLa(){
        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        ReturnHandlingEnum[] arr = ReturnHandlingEnum.values();
        for (int i = 0; i < arr.length; i++){

            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(arr[i].getSendingStatusValue());
            xiaLaVo.setLabel(arr[i].getSendingStatusName());
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }
*/


}
