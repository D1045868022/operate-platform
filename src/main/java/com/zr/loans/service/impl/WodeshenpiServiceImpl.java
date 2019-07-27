package com.zr.loans.service.impl;

import com.zr.loans.mapper.WodeshenpiMapper;
import com.zr.loans.pojo.Loans;
import com.zr.loans.pojo.WodeshenpiSelectVo;
import com.zr.loans.service.WodeshenpiService;
import com.zr.meiju.DaiKuanEnum;
import com.zr.meiju.EnquiryStatus;
import com.zr.meiju.TuiHuoEnum;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.util.StatusEnum;
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
            for(Loans loans:loansituationList){
                loans.setStatusName(StatusEnum.getstatusName(loans.getStatus()));
                loans.setBusinessTypeName(DaiKuanEnum.getName(loans.getBusinessType()));
                loans.setPushStatusName(EnquiryStatus.getName(loans.getPushStatus()));
            }


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
