package com.zr.loan.service.impl;

import com.zr.loan.mapper.LoanMapper;
import com.zr.loan.meju.*;
import com.zr.loan.pojo.LoanDetailVo;
import com.zr.loan.pojo.LoanSelectVo;
import com.zr.loan.pojo.LoanShowVo;
import com.zr.loan.service.LoanService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.xinshenstatistics.util.ResultBuildVo;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 94818 on 2019/7/6.
 */
@Service
public class LoanServiceImpl implements LoanService {

@Autowired
private LoanMapper loanMapper;


    @Override
    public ResultVO<AllRecords> queryPage(LoanSelectVo loansituationSelectVo) {
        //查询数据
        List<LoanShowVo> loansituationList = loanMapper.queryPage(loansituationSelectVo);

        //查询数量
        int count =  loanMapper.queryCount(loansituationSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(loansituationSelectVo.getPageIndex());
        allRecords.setPageSize(loansituationSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(loansituationList);
        return ResultVOBuilder.success(allRecords);

    }

    @Override
    public ResultVo<LoanDetailVo> queryByloginId(Integer loginId) {
        LoanDetailVo loanDetailVo = loanMapper.queryByloginId(loginId);
        loanDetailVo.setRelationsWithMeName(RelationEnum.getName(loanDetailVo.getRelationsWithMe()));//常用和我的关系（第一联系人）name
        loanDetailVo.setCommonRelationsWithMeName(RelationEnum.getName(loanDetailVo.getCommonRelationsWithMe()));//常用和我的关系（第一联系人）name
        loanDetailVo.setMaritalStatusName(MaritalStatusEnum.getName(loanDetailVo.getMaritalStatus()));//婚姻状况
        loanDetailVo.setLiveStatusName(LivingConditionsEnum.getName(loanDetailVo.getLiveStatus()));//居住状态
        loanDetailVo.setMyCourseName(ClassEnmu.getName(loanDetailVo.getMaritalStatus()));//我的课程
        loanDetailVo.setLiveYearName(YearsEnum.getName(loanDetailVo.getLiveYear()));//居住年限
        loanDetailVo.setPaymentCycleName(CycEnum.getName(loanDetailVo.getPaymentCycle()));//还款周期
        loanDetailVo.setOpeningBankName(OpenBankEnum.getName(loanDetailVo.getOpeningBank()));


        return ResultBuildVo.success(loanDetailVo);
    }
}
