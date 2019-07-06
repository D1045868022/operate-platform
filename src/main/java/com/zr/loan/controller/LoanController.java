package com.zr.loan.controller;

import com.zr.loan.pojo.LoanSelectVo;
import com.zr.loan.service.LoanService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 94818 on 2019/7/6.
 */
@RestController
@RequestMapping("loansituation")
public class LoanController {

    @Autowired
    private LoanService loansituationService;

    /**
     *
     *
     * 贷款情况查询
     *
     */
    @PostMapping("queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody LoanSelectVo loansituationSelectVo){
        return loansituationService.queryPage(loansituationSelectVo);
    }
    @GetMapping("queryByloginId")
    public ResultVo queryByloginId(@RequestParam("loginId") Integer loginId){
        return loansituationService.queryByloginId(loginId);
    }

}
