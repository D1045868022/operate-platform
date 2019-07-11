package com.zr.daishenpi.service.impl;

import com.zr.daishenpi.daishenpiEnum.StatusEnum;
import com.zr.daishenpi.mapper.PaydivideMapper;
import com.zr.daishenpi.pojo.PaydivideSelectVo;
import com.zr.daishenpi.pojo.PaydivideUpdateStatusVo;
import com.zr.daishenpi.service.PaydivideSerivce;
import com.zr.util.AllRecords;
import com.zr.util.ContentUtil;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 待审批列表  实现层 PaydivideServiceImpl
 * Created by 李江涛 on 2019/7/9 0009.
 */
@Service
public class PaydivideServiceImpl implements PaydivideSerivce{

    @Autowired
    private PaydivideMapper paydivideMapper;
    /**
     * 分页查询 附带模糊查询 并且统一异常处理
     * @param paydivideSelectVo
     * @return
     */
    @Override
    public ResultVO queryByPage(PaydivideSelectVo paydivideSelectVo) {

        //查询出总条数
        int count = paydivideMapper.queryCount();

        paydivideSelectVo.setStatus(StatusEnum.getstatusValue(ContentUtil.QDZT));

        //查询出全部信息 paydivideSelectVoList中有为转化的数据 status
        List<PaydivideSelectVo> paydivideSelectVoList = paydivideMapper.queryByPage(paydivideSelectVo);

        //枚举类数据转换 将值转换成中文
        List<PaydivideSelectVo> paydivideSelectVos = numberToString(paydivideSelectVoList);


        //用工具类进行分页处理
        AllRecords records=new AllRecords();
        records.setTotalNumber(count);
        records.setPageSize(paydivideSelectVo.getPageSize());
        records.setPageIndex(paydivideSelectVo.getPageIndex());
        records.setDataList(paydivideSelectVos);
        records.resetTotalNumber(count);

        return ResultVOBuilder.success(records);
    }

    /**
     * 修改审核状态  审批接口
     * @param paydivideUpdateStatusVo
     * @return
     */
    @Override
    public ResultVO updateStatus(PaydivideUpdateStatusVo paydivideUpdateStatusVo) {
        //非空判定
        if(StringUtils.isEmpty(paydivideUpdateStatusVo.getId())){
            return ResultVOBuilder.error(ContentUtil.IDISNU,ContentUtil.ERRORCODE);
        }
        if (StringUtils.isEmpty(paydivideUpdateStatusVo.getStatus())){
            return ResultVOBuilder.error(ContentUtil.STATUSISNU,ContentUtil.ERRORCODE);
        }
        //只有 ”确认状态“ 下才能走审批
        if(paydivideUpdateStatusVo.getStatus()!=StatusEnum.getstatusValue(ContentUtil.QDZT)){
            return ResultVOBuilder.error(ContentUtil.QRSTATUS,ContentUtil.ERRORCODE);
        }
        //操作数据库
        paydivideMapper.updateSpStatus(paydivideUpdateStatusVo);

        return ResultVOBuilder.success(paydivideUpdateStatusVo);
    }


    //数字转换成字符类
    public List<PaydivideSelectVo> numberToString(List<PaydivideSelectVo> paydivideSelectVoList){
        //遍历集合 进行数值和字符转换
        for (PaydivideSelectVo py:paydivideSelectVoList){
            if(py.getStatus()!=null){
                py.setStatusName(StatusEnum.getstatusName(py.getStatus()));
            }
        }

        return paydivideSelectVoList;
    }

}
