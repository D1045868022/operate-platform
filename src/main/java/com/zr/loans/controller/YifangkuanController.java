package com.zr.loans.controller;

import com.zr.loans.pojo.YifangkuanSelectVo;
import com.zr.loans.service.YifangkuanService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 已放款
 */
@RestController
public class YifangkuanController {

    @Autowired
    private YifangkuanService yifangkuanService;

    @PostMapping("/yifangkuan/queryPage")
    public ResultVO<AllRecords> YifangkuanQueryPage(@RequestBody YifangkuanSelectVo yifangkuanSelectVo){
        return yifangkuanService.queryPage(yifangkuanSelectVo);
    }

}
