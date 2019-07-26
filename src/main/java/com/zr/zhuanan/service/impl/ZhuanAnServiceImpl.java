package com.zr.zhuanan.service.impl;

import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import com.zr.zhuanan.mapper.ZhuanAnMapper;
import com.zr.zhuanan.pojo.ZhuanAnSelectVo;
import com.zr.zhuanan.pojo.ZhuanAnShowVo;
import com.zr.zhuanan.service.ZhuanAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ZhuanAnServiceImpl implements ZhuanAnService {

   @Autowired
    private ZhuanAnMapper zhuanAnMapper;


    @Override
    @Transactional
    public ResultVO distributionScheme(ZhuanAnSelectVo zhuanAnSelectVo) {

        //先查询这条数据存不存在
        ZhuanAnShowVo zhuanAnShowVo = zhuanAnMapper.queryByCode(zhuanAnSelectVo.getManagementProjectCode());
        if(zhuanAnSelectVo == null){
            return ResultVOBuilder.error("您查询的专案代码不存在","");
        }
        zhuanAnShowVo =  zhuanAnMapper.distributionSchemeFindAll(zhuanAnSelectVo);
        Integer row = 0;
        if(zhuanAnSelectVo != null){
           //修改数据
            row = zhuanAnMapper.deleteDistributionScheme(zhuanAnSelectVo);
            row = zhuanAnMapper.addDistributionScheme(zhuanAnSelectVo);
        }
        //新增数据
        row = zhuanAnMapper.addDistributionScheme(zhuanAnSelectVo);

        zhuanAnSelectVo.setReceiveStatus("接收成功");
        return ResultVOBuilder.success(zhuanAnShowVo);
    }
}
