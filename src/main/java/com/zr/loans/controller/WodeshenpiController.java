package com.zr.loans.controller;

import com.zr.loans.pojo.DaishenheSelectVo;
import com.zr.loans.pojo.WodeshenpiSelectVo;
import com.zr.loans.service.DaishenheService;
import com.zr.loans.service.WodeshenpiService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 我的审核
 */
@RestController
public class WodeshenpiController {

    @Autowired
    private WodeshenpiService wodeshenpiService;

    @PostMapping("/wodeshenhe/queryPage")
    public ResultVO<AllRecords> WodeshenheQueryPage(@RequestBody WodeshenpiSelectVo wodeshenpiSelectVo){
        return wodeshenpiService.queryPage(wodeshenpiSelectVo);
    }

}
