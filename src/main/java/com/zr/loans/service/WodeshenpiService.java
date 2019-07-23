package com.zr.loans.service;

import com.zr.loans.pojo.WodeshenpiSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

public interface WodeshenpiService {

    ResultVO<AllRecords> queryPage(WodeshenpiSelectVo wodeshenpiSelectVo);
}
