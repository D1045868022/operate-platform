package com.zr.tuihuo.service.Impl;


import com.zr.meiju.TuiHuoEnum;
import com.zr.tuihuo.mapper.TuiHuoMapper;
import com.zr.tuihuo.pojo.TuiHuo;
import com.zr.tuihuo.pojo.TuiHuoSelectVo;
import com.zr.tuihuo.pojo.TuiHuoShowVo;
import com.zr.tuihuo.service.TuiHuoService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class TuiHuoServiceImpl implements TuiHuoService {

    @Autowired
    private TuiHuoMapper tuiHuoMapper;
    @Override
    public ResultVO<AllRecords> queryPage(TuiHuoSelectVo tuiHuoSelectVo) {
        //查询数据
        List<TuiHuo> tuiHuoList = tuiHuoMapper.queryPage(tuiHuoSelectVo);
        //给状态进行赋值中文
        for (TuiHuo tuiHuo : tuiHuoList) {
            tuiHuo.setStatusName(TuiHuoEnum.getstatusName(tuiHuo.getStatus()));
        }
        //查询数量
        int count = tuiHuoMapper.queryCount(tuiHuoSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(tuiHuoSelectVo.getPageIndex());
        allRecords.setPageSize(tuiHuoSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(tuiHuoList);
        return ResultVOBuilder.success(allRecords);
    }
    @Override
    @Transactional
    public ResultVO updateTuiHuo(TuiHuoShowVo tuiHuoShowVo) {
        //验证数据是否存在
        List<String> IdCodeList = tuiHuoMapper.queryByIdCode(tuiHuoShowVo.getIdCode());
        if (CollectionUtils.isEmpty(IdCodeList)){
            return ResultVOBuilder.error("修改数据不存在！","");
        }
        tuiHuoMapper.updateTuiHuo(tuiHuoShowVo);
        return ResultVOBuilder.success(tuiHuoShowVo);
    }

}
