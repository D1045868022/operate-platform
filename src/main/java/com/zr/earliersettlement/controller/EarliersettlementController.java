package com.zr.earliersettlement.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.zr.earliersettlement.pojo.EarliersettlementSelectVo;
import com.zr.earliersettlement.pojo.EarliersettlementShowVo;
import com.zr.earliersettlement.service.EarliersettlementService;
import com.zr.meiju.BusinessTypeEnum;
import com.zr.meiju.OrderNumEnum;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.util.XiaLaVo;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 提前还请
 */
@CrossOrigin
@RestController
public class EarliersettlementController {

    @Autowired
    private EarliersettlementService earliersettlementService;


    /**
     * 分页查询
     */
    @PostMapping("earliersettlement/queryPage")
    public ResultVO<AllRecords> queryPage(@RequestBody EarliersettlementSelectVo earliersettlementSelectVo){
        return earliersettlementService.queryPage(earliersettlementSelectVo);
    }

    /**
     * 业务类型的枚举
     */
    @GetMapping("earliersettlement/businessType")
    public ResultVO<List<XiaLaVo>> queryBusinessType(){

        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        for (int i = 0; i< BusinessTypeEnum.values().length; i++){
            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(i);
            xiaLaVo.setLabel(BusinessTypeEnum.getName(i));
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }

    /**
     * 状态下拉框
     */
    @GetMapping("earliersettlement/xiala")
    public ResultVO<List<XiaLaVo>> queryXiaLa(){

        List<XiaLaVo> xiaLaVoList = new ArrayList<>();
        for (int i = 0; i< OrderNumEnum.values().length; i++){
            XiaLaVo xiaLaVo = new XiaLaVo();
            xiaLaVo.setValue(i);
            xiaLaVo.setLabel(OrderNumEnum.getName(i));
            xiaLaVoList.add(xiaLaVo);
        }
        return ResultVOBuilder.success(xiaLaVoList);
    }

    //    资方状态----下拉
    @PostMapping("earliersettlement/queryAll")
    public ResultVO queryAll(){
        return earliersettlementService.queryAll();
    }

    /**
     * 提前还请数据查询。
     * 监听银行返回的提前还请表，接收资方数据，如果有了最新的数据就发送给运营后台。
     */
    @PostMapping("/operate/earlierSettlement")
    public ResultVO earlierSettlement( @RequestBody List<EarliersettlementShowVo> earliersettlementShowVoList) {

        return earliersettlementService.updateEarliersettlement(earliersettlementShowVoList);
    }
    /**
     *  导出
     *     1.定义一个导出模板
     *     2.从数据库中查询出将要导出的数据
     *     3.把从数据库中查询出的数据赋值给导出模板
     *     4.对需要转化的数据进行转化
     *     5.在浏览器生成一个文件
     */

  /**  导出
    1.定义一个导出模板
    2.从数据库中查询出将要导出的数据
    3.把从数据库中查询出的数据赋值给导出模板
    4.对需要转化的数据进行转化
    5.在浏览器生成一个文件*/
    @GetMapping("/earliersettlement/master")
    public ResultVO exportExcel(HttpServletResponse resp, Double shenQingAmount, String orderNum, String idCode,
                                String phone,Double serviceCharge,Double penaltyInterest,Boolean orderStatus) throws Exception{
        EarliersettlementSelectVo earliersettlementSelectVo = new EarliersettlementSelectVo();
        earliersettlementSelectVo.setShenQingAmount(shenQingAmount);
        earliersettlementSelectVo.setOrderNum(orderNum);
        earliersettlementSelectVo.setIdCode(idCode);
        earliersettlementSelectVo.setPhone(phone);
        earliersettlementSelectVo.setServiceCharge(serviceCharge);
        earliersettlementSelectVo.setPenaltyInterest(penaltyInterest);
        earliersettlementSelectVo.setOrderStatus(orderStatus);
        return earliersettlementService.exportExcel(resp,earliersettlementSelectVo);
    }


}
