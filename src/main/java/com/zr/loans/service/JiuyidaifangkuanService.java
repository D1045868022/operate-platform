package com.zr.loans.service;

import com.zr.loans.pojo.JiuYiToBelentSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;


/**
 * Created by 86151 on 2019/4/22.
 */
public interface JiuyidaifangkuanService {


    ResultVO<AllRecords> queryPage(JiuYiToBelentSelectVo jiuYiToBelentSelectVo);

 /*   ResultVO exportExcel(HttpServletResponse resp, JiuYiToBelentSelectVo jiuYiToBelentSelectVo) throws Exception;

    ResultVO queryAll();*/
//    ResultVO addMechant(MechantAddVo mechantAddVo);
//    ResultVO updateMechant(MechantUpdateVo mechantUpdateVo);
}







