package com.zr.loans.service;

import com.zr.loans.pojo.DaishenheSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

public interface DaishenheService {

    ResultVO<AllRecords> queryPage(DaishenheSelectVo daishenheSelectVo);
}
