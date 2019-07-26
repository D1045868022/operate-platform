package com.zr.tuihuo.service;

import com.zr.tuihuo.pojo.TuiHuoSelectVo;
import com.zr.tuihuo.pojo.TuiHuoShowVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

public interface TuiHuoService {

    ResultVO<AllRecords> queryPage(TuiHuoSelectVo tuiHuoSelectVo);


    ResultVO updateTuiHuo(TuiHuoShowVo tuiHuoShowVo);
}
