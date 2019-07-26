package com.zr.bangka.service;


import com.zr.bangka.pojo.BangKaAddVo;
import com.zr.bangka.pojo.BangKaSelectVo;
import com.zr.bangka.pojo.BangKaShowVo;
import com.zr.bangka.pojo.YinHangVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

import java.util.List;

public interface BangKaService {


    ResultVO bangka(List<BangKaShowVo> bangKaShowVoList);

    ResultVO<AllRecords> queryPage(BangKaSelectVo bangKaSelectVo);

    ResultVO bangKaAdd(BangKaAddVo bangKaAddVo);

    ResultVO send(BangKaShowVo bangKaShowVo);

    ResultVO yinhang(YinHangVo yinHangVo);
}
