package com.zr.loans.service.impl;

import com.zr.loans.mapper.LoansituationMapper;
import com.zr.loans.pojo.Loans;
import com.zr.loans.pojo.LoansituationSelectVo;
import com.zr.loans.service.LoansituationService;
import com.zr.mechant.enumall.StatusEnum;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by star on 2019/6/21.
 */
@Service
public class LoansituationServiceImpl implements LoansituationService {
    @Autowired
    private LoansituationMapper loansituationMapper;

   /**
     * 资方--分页
     */
    @Override
    public ResultVO<AllRecords> queryPage(LoansituationSelectVo loansituationSelectVo) {
        //查询数据
        List<Loans> loansituationList = loansituationMapper.queryPage(loansituationSelectVo);

        //查询数量
        int count =  loansituationMapper.queryCount(loansituationSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(loansituationSelectVo.getPageIndex());
        allRecords.setPageSize(loansituationSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(loansituationList);
        return ResultVOBuilder.success(allRecords);
    }

}
