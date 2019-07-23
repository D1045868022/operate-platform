package com.zr.loans.service;

import com.zr.loans.pojo.YifangkuanSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.xinshenstatistics.util.ResultVo;

public interface YifangkuanService {

    ResultVO<AllRecords> queryPage(YifangkuanSelectVo yifangkuanSelectVo);
}
