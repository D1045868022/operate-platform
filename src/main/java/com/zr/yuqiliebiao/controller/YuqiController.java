package com.zr.yuqiliebiao.controller;


import com.zr.util.ResultVO;
import com.zr.yuqiliebiao.pojo.Overduelist;
import com.zr.yuqiliebiao.pojo.OverduelistVo;
import com.zr.yuqiliebiao.service.YuqiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin

public class YuqiController {

    @Autowired
    private YuqiService yuqiService;

    /**
     * 分页查询数据库 overduelist 表中的数据
     */
    @PostMapping("/overdure/getOverdureData")
    public ResultVO queryByPage(@RequestBody OverduelistVo overduelistVo){
        return yuqiService.queryByPage(overduelistVo);
    }

    /**
     * 接收由银行传来的逾期数据
     * @return
     */
    @PostMapping("yuqi/operate/overdueList")
    public ResultVO overdueList(@RequestBody List<Overduelist> overduelists){
        return yuqiService.overdueList(overduelists);
    }
    //导出
    @GetMapping("/hd/overdure/overdureExport")
    public ResultVO exportExcel(HttpServletResponse response, String idCode, String phone , String name)throws Exception{
        OverduelistVo overduelistVo=new OverduelistVo();
        overduelistVo.getIdCode();
        overduelistVo.getName();
        overduelistVo.getPhone();
        return yuqiService.exportExcel(response,overduelistVo);

    }
}
