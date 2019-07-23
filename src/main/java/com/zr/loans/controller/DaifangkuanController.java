package com.zr.loans.controller;

import com.zr.loans.pojo.DaiFangKuanSelectVo;
import com.zr.loans.pojo.PullDown;
import com.zr.loans.service.DaifangkuanService;
import com.zr.util.AllRecords;
import com.zr.util.LoansStatusEnum;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 16:34
 */
@RestController
@CrossOrigin
public class DaifangkuanController {

    @Autowired
    private DaifangkuanService daiFangKuanService;


    /**
     * 导出
     */
   /* @PostMapping("/daifangkuan/InquiryIntroduction")
    public ResultVO exportDFK(HttpServletResponse response,String statusName, String name, Integer phone, String merchant){
        DaiFangKuanSelectVo daiFangKuanSelectVo = new DaiFangKuanSelectVo();
        daiFangKuanSelectVo.setStatusName(statusName);
        daiFangKuanSelectVo.setName(name);
        daiFangKuanSelectVo.setMerchant(merchant);
        daiFangKuanSelectVo.setPhone(phone);
        return daiFangKuanService.exportDFK(response, daiFangKuanSelectVo);
    }*/


    /**
     * 分页查询
     * @param daiFangKuanSelectVo
     * @return
     */
    @PostMapping("/Loans/DaiFangKuanqueryPage")
    public ResultVO<AllRecords> DaiFangKuanqueryPage(@RequestBody DaiFangKuanSelectVo daiFangKuanSelectVo){
        return daiFangKuanService.queryPage(daiFangKuanSelectVo);
    }

    /**
     * 状态下拉框
     */
   /* @PostMapping("/daifangkuan/getPullDownList")
    public ResultVO<List<PullDown>> findPullDownList(){
        List<PullDown> dfkStatusEnumList = new ArrayList<>();
        for(int i = 0; i < LoansStatusEnum.values().length; i ++){
            PullDown pullDown = new PullDown();
            pullDown.setVarlue(i);
            pullDown.setLabel(LoansStatusEnum.getStatusName(i));
            dfkStatusEnumList.add(pullDown);
        }
        return ResultVOBuilder.success(dfkStatusEnumList);
    }*/

}
