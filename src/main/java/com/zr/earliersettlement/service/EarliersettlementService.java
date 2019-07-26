package com.zr.earliersettlement.service;


import com.zr.earliersettlement.pojo.EarliersettlementSelectVo;
import com.zr.earliersettlement.pojo.EarliersettlementShowVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.xinshenstatistics.util.ResultVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface EarliersettlementService {


    ResultVO<AllRecords> queryPage(EarliersettlementSelectVo earliersettlementSelectVo);

    ResultVO queryAll();


    ResultVO updateEarliersettlement(List<EarliersettlementShowVo> earliersettlementShowVoList);

    ResultVO exportExcel(HttpServletResponse resp, EarliersettlementSelectVo earliersettlementSelectVo) throws Exception ;
}
