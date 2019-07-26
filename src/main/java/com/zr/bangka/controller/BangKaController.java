package com.zr.bangka.controller;


import com.zr.bangka.pojo.BangKaAddVo;
import com.zr.bangka.pojo.BangKaSelectVo;
import com.zr.bangka.pojo.BangKaShowVo;
import com.zr.bangka.pojo.YinHangVo;
import com.zr.bangka.service.BangKaService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class BangKaController {
    @Autowired
    private BangKaService bangKaService;
    /**
     * 绑卡信息入库
     */
    @PostMapping("/bangKaAdd")
    public ResultVO bangKaAdd(@RequestBody @Valid BangKaAddVo bangKaAddVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultVOBuilder.error(bindingResult.getFieldError().getDefaultMessage(),"");
        }

        return bangKaService.bangKaAdd(bangKaAddVo);
    }
    /**
     *发送给资方信息
     *监听并接收资方数据，如果有了最新的数据就发送给运营后台进行业务处理。
     *
     */

    @GetMapping("/bangka/send")
    public ResultVO send( BangKaShowVo bangKaShowVo){

        return bangKaService.send(bangKaShowVo);

    }

    /**
     * 接收资方客户绑卡信息并处理
     */
    @PostMapping("/operate/customerBindingCard")
    public ResultVO bangka(@RequestBody List<BangKaShowVo> bangKaShowVoList) {

        return bangKaService.bangka(bangKaShowVoList);
    }


    /**
     * 分页查询
     */
    @PostMapping("bangka/queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody BangKaSelectVo bangKaSelectVo) {
        return bangKaService.queryPage(bangKaSelectVo);
    }

    /**
     * 效验银行卡
     */
    @PostMapping("/operate/VerificationBankCard")
    public ResultVO yinhang(@RequestBody YinHangVo yinHangVo){
        return bangKaService.yinhang(yinHangVo);
    }
}
