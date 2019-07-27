package com.zr.mechant.service.impl;


import com.zr.mechant.enumall.IsNoEnum;
import com.zr.mechant.enumall.StatusEnum;
import com.zr.mechant.enumall.TypeEnum;
import com.zr.mechant.mapper.MechantMapper;

import com.zr.mechant.model.*;
import com.zr.mechant.service.MechantService;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.xinshenstatistics.util.ResultBuildVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by 86151 on 2019/4/22.
 */
@Service
public class MechantServiceimpl implements MechantService {
    @Autowired
    private MechantMapper mechantMapper;


    @Override
    public ResultVO<AllRecords> queryPage(MechantSelectVo mechantSelectVo) {
       //1.查询总条数
        int count = mechantMapper.queryCount(mechantSelectVo);
        //2.查询具体数据信息
        List<MechantInfo> mechantInfos = mechantMapper.queryPage(mechantSelectVo);
        //给数据中的中文赋值
        assigementName(mechantInfos);
        //3.new AllRecords给allRecordes赋值
        AllRecords allRecords = new AllRecords();
        allRecords.setTotalNumber(count);
        allRecords.setPageSize(mechantSelectVo.getPageSize());
        allRecords.setPageIndex(mechantSelectVo.getPageIndex());
        allRecords.setDataList(mechantInfos);
        allRecords.resetTotalNumber(count);


        //4.返回allRecordes
        return ResultVOBuilder.success(allRecords);
    }
    public void assigementName(List<MechantInfo> mechantInfoList){
        for (MechantInfo me : mechantInfoList) {
            if (me.getStatus()!=null&&!StringUtils.isEmpty(me.getStatus())){
             me.setStatusName(StatusEnum.getStatusName(me.getStatus()));
            }
            if (me.getBusinessType()!=null&&!StringUtils.isEmpty(me.getBusinessType())){
             me.setBusinessTypeName(TypeEnum.getTypeName(me.getBusinessType()));
            }
            if (me.getIsornocontract()!=null&&!StringUtils.isEmpty(me.getIsornocontract())){
                me.setIsornocontractName(IsNoEnum.getIsNoName(me.getIsornocontract()));
            }

        }
    }

    @Override
    @Transactional
    public ResultVO addMechant(MechantAddVo mechantAddVo)throws Exception{
        //查询验证码是否存在
        Mechant mechant1 = mechantMapper.queryMeChantInvitationcode(mechantAddVo.getMechantInvitationcode());
        if(mechant1 != null){
            return ResultVOBuilder.error("500","该邀请码已经存在，请选择别的重试");
        }
        //验证商户名称是否具有唯一性
       Mechant mechant =  mechantMapper.queryMechantName(mechantAddVo.getMerchantName());
        if(mechant != null){
            return ResultVOBuilder.error("500","商户名称重复，请确认后重新输入或者联系客服");
        }
        Date date = new Date();
        mechantAddVo.setCreateName("谢烽");
        mechantAddVo.setCreateTime(date);
        mechantAddVo.setUpdateName("谢烽");
        mechantAddVo.setUpdateTime(date);
        //先插入商户表
        mechantMapper.addMechant(mechantAddVo);
        //批量插入图片信息
        List<Mechant_Pic> mechantPicList = new ArrayList<>();
        for (Mechant_Pic mechantPic : mechantAddVo.getMechantPicList()){
            mechantPic.setMechantId(mechantAddVo.getId());
            mechantPicList.add(mechantPic);
        }
        mechantMapper.addMp(mechantPicList);
        return ResultVOBuilder.success(mechantAddVo);
    }

    @Override
    @Transactional
    //修改
    public ResultVO updateMechant(MechantUpdateVo mechantUpdateVo) {
        Mechant mechant1 =  mechantMapper.queryMechantName(mechantUpdateVo.getMerchantName());

        if (mechant1 == null){
          return ResultVOBuilder.error("您要修改的数据不存在！","500");
        }

        Mechant mechant = new Mechant();
        Mechant_Configure mechant_configure = new  Mechant_Configure();
        Mechant_Pic mechant_pic = new Mechant_Pic();
//        Mechant_SpeedProgress mechant_speedprogress = new Mechant_SpeedProgress();

        Mechant_Generatinginformation mechant_generatinginformation=new Mechant_Generatinginformation();
//        Mechant_Other mechant_other=new Mechant_Other();
//        Mechant_ZhiFuBao mechant_zhiFuBao=new Mechant_ZhiFuBao();
        Merchant_Capital merchant_capital=new Merchant_Capital();


        BeanUtils.copyProperties(mechantUpdateVo,mechant);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_pic);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_configure);
//        BeanUtils.copyProperties(mechantUpdateVo, mechant_speedprogress);
        BeanUtils.copyProperties(mechantUpdateVo, mechant_generatinginformation);
//        BeanUtils.copyProperties(mechantUpdateVo, mechant_other);
//        BeanUtils.copyProperties(mechantUpdateVo, mechant_zhiFuBao);
        BeanUtils.copyProperties(mechantUpdateVo, merchant_capital);

        mechantMapper.updateMechant(mechant);
        mechantMapper.updataMp(mechant_configure);
        mechantMapper.updatePicList(mechantUpdateVo.getMechantPicList());
//        mechantMapper.updateSpeedProgressList(mechantUpdateVo.getMechant_speedProgressList());
        mechantMapper.updateMg(mechant_generatinginformation);
//        mechantMapper.updateOtherList(mechantUpdateVo.getMechant_otherList());
//        mechantMapper.updateMz(mechant_zhiFuBao);
        mechantMapper.updateMcp(merchant_capital);

        return ResultVOBuilder.success(mechantUpdateVo);

//        int update = mechantMapper.updateMechant(mechantUpdateVo);
//        if (update == 0){
//            return ResultVOBuilder.error("数据已更新，请重新修改！","500");
//        }


    }

    @Override
    public ResultVO queryMechantAll(Integer id){

        if(id==null){
            return ResultVOBuilder.error("500","用户状态异常");

        }
        MechantUpdateVo mechantUpdateVo=mechantMapper.queryMechantAllById(id);
     /*   List<Mechant_Other> mechant_othersList = mechantMapper.queryOtherByMid(id);
        List<Mechant_Pic> mechant_pics = mechantMapper.queryPicByMid(id);
        List<Mechant_SpeedProgress> mechant_speedProgresses = mechantMapper.querySpeedProgressByMid(id);
        mechantUpdateVo.setMechant_otherList(mechant_othersList);
        mechantUpdateVo.setMechant_speedProgressList(mechant_speedProgresses);*/
//        mechantUpdateVo.setMechantPicList(mechant_pics);
        return ResultVOBuilder.success(mechantUpdateVo);
    }

}
