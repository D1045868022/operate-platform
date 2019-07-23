package com.zr.loans.controller;

import com.zr.loans.pojo.DaishenheSelectVo;
import com.zr.loans.pojo.YifangkuanSelectVo;
import com.zr.loans.service.DaishenheService;
import com.zr.loans.service.YifangkuanService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 待审核
 */
@RestController
public class DaishenheController {

    @Autowired
    private DaishenheService daishenheService;

    @PostMapping("/daishenhe/queryPage")
    public ResultVO<AllRecords> DaishenheQueryPage(@RequestBody DaishenheSelectVo daishenheSelectVo){
        return daishenheService.queryPage(daishenheSelectVo);
    }

}
