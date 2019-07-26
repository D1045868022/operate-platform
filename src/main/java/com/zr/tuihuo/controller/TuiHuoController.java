package com.zr.tuihuo.controller;


import com.zr.tuihuo.pojo.TuiHuoSelectVo;
import com.zr.tuihuo.pojo.TuiHuoShowVo;
import com.zr.tuihuo.service.TuiHuoService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TuiHuoController {
    @Autowired
    private TuiHuoService tuiHuoService;

    /**
     * 退货分页查询
     */
    @PostMapping("/returnHandling/queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody TuiHuoSelectVo tuiHuoSelectVo) {

     return tuiHuoService.queryPage(tuiHuoSelectVo);
     }
    /**
     *发送给资方身份证号
     *监听并接收资方数据，如果有了最新的数据就发送给运营后台进行业务处理。
     *
     */

    @PostMapping("operate/queryReturnGoods")
    public ResultVO updateTuiHuo(@RequestBody TuiHuoShowVo tuiHuoShowVo){

        return tuiHuoService.updateTuiHuo(tuiHuoShowVo);

    }


}
