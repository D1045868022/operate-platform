package com.zr.loans.service.impl;

import com.zr.loans.mapper.YifangkuanMapper;
import com.zr.loans.pojo.Loans;
import com.zr.loans.pojo.YifangkuanSelectVo;
import com.zr.loans.service.YifangkuanService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YifangkuanServiceImpl implements YifangkuanService {

    @Autowired
    private YifangkuanMapper yifangkuanMapper;

    @Override
    public ResultVO<AllRecords> queryPage(YifangkuanSelectVo yifangkuanSelectVo) {
        //查询数据
        List<Loans> loansituationList = yifangkuanMapper.queryPage(yifangkuanSelectVo);

        //查询数量
        int count =  yifangkuanMapper.queryCount(yifangkuanSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(yifangkuanSelectVo.getPageIndex());
        allRecords.setPageSize(yifangkuanSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(loansituationList);
        return ResultVOBuilder.success(allRecords);
    }
}
