package com.zr.riskmanagement.service.impl;

import com.zr.riskmanagement.mapper.RiskMapper;
import com.zr.riskmanagement.pojo.*;
import com.zr.riskmanagement.service.RiskMangamentService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.xinshenstatistics.util.ResultBuildVo;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by 94818 on 2019/6/22.
 */
@Service
public class RiskMangamentServiceImpl implements RiskMangamentService{
    @Autowired
    private RiskMapper riskMapper;

    @Override
    @Transactional
    public ResultVO add(RiskReserveAddVo riskReserveAddVo) {
        //商户ID不能为空
        if(StringUtils.isEmpty(riskReserveAddVo.getRemeId())){
            return ResultVOBuilder.error("500","商户ID不能为空");
        }else{
            RiskReserve riskReserve=new RiskReserve();
            riskReserve.setRemeId(riskReserveAddVo.getRemeId());
            riskReserve.setLineCredit(riskReserveAddVo.getLineCredit());
            riskReserve.setReserveCoefficient(riskReserveAddVo.getReserveCoefficient());
            riskReserve.setRiskReserve(riskReserveAddVo.getRiskReserve());
            riskMapper.addRiskReserve(riskReserve);
            if(!StringUtils.isEmpty(riskReserveAddVo.getCapitalSide())){
                RiskreserveCapitalsideMiddle risksideMiddle =new RiskreserveCapitalsideMiddle();
                RiskreserveCapitalside byCapitalName = riskMapper.findByCapitalName(riskReserveAddVo.getCapitalSide());
                if(byCapitalName!=null){
                    risksideMiddle.setCapitalsideId(byCapitalName.getId());
                }else{
                    return ResultVOBuilder.error("500","查询不到风险准备金-资金方表信息");
                }
                risksideMiddle.setRiskreserveId(riskReserve.getId());
                riskMapper.addSideMiddle(risksideMiddle);
            }
            if(!StringUtils.isEmpty(riskReserveAddVo.getPic())) {
                RiskReserveZiliao riskReserveZiliao =new RiskReserveZiliao();
                riskReserveZiliao.setPic(riskReserveAddVo.getPic());
                riskReserveZiliao.setRiskReserveId(riskReserve.getId());
                riskMapper.addRiskZiliao(riskReserveZiliao);
            }
        }

        return ResultVOBuilder.success(riskReserveAddVo);
    }

    @Override
    public ResultVO queryMainenancestaff() {
        List<Maintenancestaff> maintenancestaffs = riskMapper.queryMainenancestaff();
        return ResultVOBuilder.success(maintenancestaffs);
    }

    @Override
    public ResultVO<AllRecords> queryPage(RiskReserveSelectVo riskReserveSelectVo) {
        //查询数据
        List<RiskReserveShowVo> riskReserveShowVoList = riskMapper.queryPage(riskReserveSelectVo);
        //查询数量
        int count =  riskMapper.queryCount(riskReserveSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(riskReserveSelectVo.getPageIndex());
        allRecords.setPageSize(riskReserveSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(riskReserveShowVoList);
        return ResultVOBuilder.success(allRecords);
    }

    @Override
    public ResultVo<RiskReserveShowIdVo> queryByremeId(Integer remeId) {
        RiskReserveShowIdVo riskReserveShowIdVos = riskMapper.queryByremeId(remeId);
        return ResultBuildVo.success(riskReserveShowIdVos);
    }
}
