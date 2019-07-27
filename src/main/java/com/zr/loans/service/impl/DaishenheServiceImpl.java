package com.zr.loans.service.impl;

import com.zr.loans.mapper.DaishenheMapper;
import com.zr.loans.pojo.DaishenheSelectVo;
import com.zr.loans.pojo.Loans;
import com.zr.loans.service.DaishenheService;
import com.zr.meiju.DaiKuanEnum;
import com.zr.meiju.EnquiryStatus;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.util.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaishenheServiceImpl implements DaishenheService {

    @Autowired
    private DaishenheMapper daishenheMapper;

    @Override
    public ResultVO<AllRecords> queryPage(DaishenheSelectVo daishenheSelectVo) {
        //1.查询具体数据信息
        List<Loans> loansList = daishenheMapper.queryPage(daishenheSelectVo);
        for (Loans loans : loansList) {
            loans.setStatusName(StatusEnum.getstatusName(loans.getStatus()));
            loans.setBusinessTypeName(DaiKuanEnum.getName(loans.getBusinessType()));
            loans.setPushStatusName(EnquiryStatus.getName(loans.getPushStatus()));
        }
        //2.查询总条数
        int count = daishenheMapper.queryCount(daishenheSelectVo);

        //3.new AllRecords给allRecordes赋值
        AllRecords allRecords = new AllRecords();
        allRecords.setTotalNumber(count);
        allRecords.setPageSize(daishenheSelectVo.getPageSize());
        allRecords.setPageIndex(daishenheSelectVo.getPageIndex());
        allRecords.setDataList(loansList);
        allRecords.resetTotalNumber(count);

        //4.返回allRecordes
        return ResultVOBuilder.success(allRecords);
    }
}
