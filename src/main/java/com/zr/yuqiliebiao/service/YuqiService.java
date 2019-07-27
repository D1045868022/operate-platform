package com.zr.yuqiliebiao.service;


import com.zr.util.ResultVO;
import com.zr.yuqiliebiao.pojo.Overduelist;
import com.zr.yuqiliebiao.pojo.OverduelistVo;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface YuqiService {
    //分页查询
    ResultVO queryByPage(OverduelistVo overduelistVo);
    ResultVO overdueList(List<Overduelist> overduelists);

    ResultVO exportExcel(HttpServletResponse response, OverduelistVo overduelistVo) throws Exception;
}
