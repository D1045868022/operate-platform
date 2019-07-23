package com.zr.loans.service.impl;

import com.zr.loans.mapper.WodeshenpiMapper;
import com.zr.loans.pojo.Loans;
import com.zr.loans.pojo.WodeshenpiSelectVo;
import com.zr.loans.service.WodeshenpiService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WodeshenpiServiceImpl implements WodeshenpiService {
    @Autowired
    private WodeshenpiMapper wodeshenpiMapper;

    @Override
    public ResultVO<AllRecords> queryPage(WodeshenpiSelectVo wodeshenpiSelectVo) {
        //查询数据
        List<Loans> loansituationList = wodeshenpiMapper.queryPage(wodeshenpiSelectVo);

        //查询数量
        int count =  wodeshenpiMapper.queryCount(wodeshenpiSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(wodeshenpiSelectVo.getPageIndex());
        allRecords.setPageSize(wodeshenpiSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(loansituationList);
        return ResultVOBuilder.success(allRecords);
    }
}
