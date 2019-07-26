package com.zr.zhuanan.controller;


import com.zr.util.ResultVO;
import com.zr.zhuanan.pojo.ZhuanAnSelectVo;
import com.zr.zhuanan.service.ZhuanAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZhuanAnController {

    @Autowired
    private ZhuanAnService zhuanAnService;


    /**
     * 4.银行发送配送方案给运营平台
     */
    @PostMapping("/operate/distributionScheme")
    public ResultVO distributionScheme(@RequestBody ZhuanAnSelectVo zhuanAnSelectVo){

        return zhuanAnService.distributionScheme(zhuanAnSelectVo);
    }




}
