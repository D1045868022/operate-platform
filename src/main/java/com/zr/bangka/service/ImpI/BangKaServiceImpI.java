package com.zr.bangka.service.ImpI;


import com.zr.bangka.mapper.BangKaMapper;
import com.zr.bangka.pojo.*;
import com.zr.bangka.service.BangKaService;
import com.zr.meiju.BankCardEnum;
import com.zr.meiju.CardEnum;
import com.zr.meiju.YanZhengEnum;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.xinshenstatistics.util.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class BangKaServiceImpI implements BangKaService {
    @Autowired
    private BangKaMapper bangKaMapper;

    @Override
    public ResultVO bangka(List<BangKaShowVo> bangKaShowVoList) {
        List<String> orderNumberList = new ArrayList<>();
        //先验证数据是否存在，把存在了的数据删除掉
        for (BangKaShowVo bangKaShowVo:bangKaShowVoList){
            orderNumberList.add(bangKaShowVo.getBankCard());
        }
        List<BangKaShowVo>  bangKaShowVos = bangKaMapper.queryBankCardByCodes(orderNumberList);
        if(!CollectionUtils.isEmpty(bangKaShowVos)){
            bangKaMapper.updateStatus(bangKaShowVos);
            bangKaMapper.insertBangKa(bangKaShowVoList);

        }else{
            bangKaMapper.insertBangKa(bangKaShowVoList);
        }
        return ResultVOBuilder.success(bangKaShowVoList);
    }

    @Override
    public ResultVO<AllRecords> queryPage(BangKaSelectVo bangKaSelectVo) {
        //查询数据
        List<BangKaVo> bangKaVoList = bangKaMapper.queryPage(bangKaSelectVo);

        for (BangKaVo bangKaVo:bangKaVoList){
            //给卡状态赋值中文
            Integer cardStatus = bangKaVo.getCardStatus()==true?0:1;
            bangKaVo.setCardStatusName(CardEnum.getName(cardStatus));
            //给验证状态赋值中文
            bangKaVo.setYanZhengStatusName(YanZhengEnum.getName(bangKaVo.getYanZhengStatus()));
            //给银行开户行赋值中文
            bangKaVo.setBankTypeName(BankCardEnum.getName(bangKaVo.getBankCardType()));
        }
        //查询数量
        int count = bangKaMapper.queryCount(bangKaSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(bangKaSelectVo.getPageIndex());
        allRecords.setPageSize(bangKaSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(bangKaVoList);
        return ResultVOBuilder.success(allRecords);

    }
    @Override
    @Transactional
    public ResultVO bangKaAdd(BangKaAddVo bangKaAddVo) {
        BangKaVo bangKaVo = bangKaMapper.queryAll(bangKaAddVo);

        if(bangKaVo==null){
            bangKaMapper.bangKaAdd(bangKaAddVo);
        }else {
           return ResultVOBuilder.error("存入对象已存在","");
        }
        return ResultVOBuilder.success(bangKaAddVo);
    }

    @Override
    @Transactional
    public ResultVO send(BangKaShowVo bangKaShowVo) {
        //验证数据是否存在
        List<String> loanContractNumList = bangKaMapper.queryByNum(bangKaShowVo.getBankCard());
        if (CollectionUtils.isEmpty(loanContractNumList)){
            return ResultVOBuilder.error("修改数据不存在！","");
        }
        bangKaMapper.update(bangKaShowVo);
        bangKaMapper.insert(bangKaShowVo);
        return ResultVOBuilder.success(bangKaShowVo);
    }

    @Override
    public ResultVO yinhang(YinHangVo yinHangVo) {

        //先查询这条数据存不存在
        YinHangVo yinHangVo1 = bangKaMapper.queryByCode(yinHangVo.getIdCode());
        if (yinHangVo1 == null) {
            return ResultVOBuilder.error("您查询身份证号码不存在","");
        }
        yinHangVo = bangKaMapper.yinhangFindAll(yinHangVo);
        Integer row = 0;
        if (yinHangVo != null) {
            //修改数据
            row = bangKaMapper.deleteYinHang(yinHangVo);
            row = bangKaMapper.addYinHang(yinHangVo);
        }
        //新增数据
        row = bangKaMapper.addYinHang(yinHangVo);

        yinHangVo.setReceiveStatus("接收成功");
        return ResultVOBuilder.success(yinHangVo);
    }

}

