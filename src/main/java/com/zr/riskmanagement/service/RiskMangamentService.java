package com.zr.riskmanagement.service;

import com.zr.riskmanagement.pojo.RiskReserveAddVo;
import com.zr.riskmanagement.pojo.RiskReserveSelectVo;
import com.zr.riskmanagement.pojo.RiskReserveShowIdVo;
import com.zr.riskmanagement.pojo.RiskReserveShowVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.xinshenstatistics.util.ResultVo;

/**
 * Created by 94818 on 2019/6/22.
 */
public interface RiskMangamentService {

    ResultVO add(RiskReserveAddVo riskReserveAddVo);

    ResultVO queryMainenancestaff();

    ResultVO<AllRecords> queryPage(RiskReserveSelectVo riskReserveSelectVo);

    ResultVo<RiskReserveShowIdVo> queryByremeId(Integer remeId);
}
