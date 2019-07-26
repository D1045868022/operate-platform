package com.zr.pikou.controller;


import com.zr.meiju.ApprovalChannelMnum;
import com.zr.meiju.IsApprovalEnum;
import com.zr.pikou.pojo.ApprovalSelectVo;
import com.zr.pikou.pojo.ApprovalShowVo;
import com.zr.pikou.pojo.QueryBySelectVo;
import com.zr.pikou.service.ApprovalService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.util.XiaLaVo;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *5.批扣列表数据
 */
@RestController
@CrossOrigin
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    /**
     * 分页查询接口
     */
    @PostMapping("operate/queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody ApprovalSelectVo approvalSelectVo) {

        return approvalService.queryPage(approvalSelectVo);
    }

    /**
     * 提前还请数据查询。
     * 监听银行返回的批扣列表，接收资方数据，如果有了最新的批扣数据就发送给运营后台。
     */
    @PostMapping("/operate/queryPikouList")
    public ResultVO earlierSettlement( @RequestBody List<ApprovalSelectVo> approvalSelectVos) {

        return approvalService.updateBankApproval(approvalSelectVos);
    }
    /**
     *发送给资方贷款合同号
     *监听并接收资方数据，如果有了最新的批扣数据就发送给运营后台进行业务处理。
     *
     */

    @GetMapping("/operate/pikou")
    public ResultVO pikou(ApprovalShowVo approvalShowVo){

           return approvalService.updateApproval(approvalShowVo);

    }

    /**
     * 是否可批扣下拉框
     */
    @GetMapping("/pikouDropdownBox")
    public ResultVO<List<XiaLaVo>> queryZhiYe(){
        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        IsApprovalEnum[] arr = IsApprovalEnum.values();
        for (int i = 0; i < arr.length; i++){
            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(arr[i].getIsApprovalValue());
            xiaLaVo.setLabel(arr[i].getIsApprovalName());
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }
    /**
     * 批扣渠道下拉框
     */
    @GetMapping("/qudaoDropdownBox")
    public ResultVO<List<XiaLaVo>> queryXueLi(){
        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        ApprovalChannelMnum[] arr = ApprovalChannelMnum.values();
        for (int i = 0; i < arr.length; i++){

            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(arr[i].getApprovalChanneValue());
            xiaLaVo.setLabel(arr[i].getApprovalChanneName());
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }
    /**
     * 批扣流水分页查询接口
     */
    @PostMapping("pikouflowingwater/queryBySelect")
    public ResultVO<AllRecords> queryBySelect(@RequestBody QueryBySelectVo queryBySelectVo) {

        return approvalService.queryBySelect(queryBySelectVo);
    }

}
