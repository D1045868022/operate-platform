package com.zr.capital.controller;

import com.zr.capital.pojo.OverdueListSelectVo;
import com.zr.capital.pojo.SignContractVo;
import com.zr.capital.pojo.TobelentListVo;
import com.zr.capital.service.CapitalService;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * 资方向运营后台放松接口
 */
@RestController
public class CapitalController {

    @Autowired
    private CapitalService capitalService;


    /**
     * 签约成功发送签约成功信息给运营平台
     * @param signContractVo 接收的数据
     * @param bindingResult 表单验证
     * @return
     */
    @PostMapping("/operate/signContract")
    public ResultVO operateSignContract(@RequestBody @Valid SignContractVo signContractVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOBuilder.error("500",bindingResult.getFieldError().getDefaultMessage());
        }
        return capitalService.signContract(signContractVo);
    }


    /**
     * 放款后发送放款金额、订单号、资方状态给运营平台
     * @param tobelentListVo
     * @param bindingResult
     * @return
     */
    @PostMapping("/operate/tobelentList")
    public ResultVO tobelentList(@RequestBody @Valid TobelentListVo tobelentListVo, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultVOBuilder.error("500",bindingResult.getFieldError().getDefaultMessage());
        }
        return capitalService.tobelentList(tobelentListVo);
    }

    /**
     * 接收由银行传来的逾期数据
     * @param overdueListSelectVo
     * @return
     */
    @PostMapping("/operate/overdueList")
    public ResultVO overdueList(@RequestBody List<OverdueListSelectVo> overdueListSelectVo){
        return capitalService.overdueList(overdueListSelectVo);
    }

}
