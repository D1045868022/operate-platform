package com.zr.shenpiliebiao.service.impl;



import com.zr.daishenpi.daishenpiEnum.StatusEnum;
import com.zr.daishenpi.pojo.PaydivideSelectVo;
import com.zr.shenpiliebiao.shenpiEnum.SpStatusEnum;
import com.zr.shenpiliebiao.mapper.SpPaydivideMapper;
import com.zr.shenpiliebiao.pojo.SpPaydivideSelectVo;
import com.zr.shenpiliebiao.service.SpPaydivideSerivce;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 待审批列表  实现层 PaydivideServiceImpl
 * Created by 李江涛 on 2019/7/9 0009.
 */
@Service
public class SpPaydivideServiceImpl implements SpPaydivideSerivce {

    @Autowired
    private SpPaydivideMapper spPaydivideMapper;
    /**
     * 分页查询 附带模糊查询 并且统一异常处理
     * @param spPaydivideSelectVo
     * @return
     */
    @Override
    public ResultVO queryByPage(SpPaydivideSelectVo spPaydivideSelectVo) {

        //查询出总条数
        int count = spPaydivideMapper.queryCount();

        //查询出全部信息 paydivideSelectVoList中有为转化的数据 status
        List<SpPaydivideSelectVo> spPaydivideSelectVoList = spPaydivideMapper.queryByPage(spPaydivideSelectVo);

        //枚举类数据转换 将值转换成中文
        List<SpPaydivideSelectVo> paydivideSelectVos = numberToString(spPaydivideSelectVoList);

        //用工具类进行分页处理
        AllRecords records=new AllRecords();
        records.setTotalNumber(count);
        records.setPageSize(spPaydivideSelectVo.getPageSize());
        records.setPageIndex(spPaydivideSelectVo.getPageIndex());
        records.setDataList(spPaydivideSelectVoList);
        records.resetTotalNumber(count);

        return ResultVOBuilder.success(records);
    }
    //数字转换成字符类
    public List<SpPaydivideSelectVo> numberToString(List<SpPaydivideSelectVo> paydivideSelectVoList){
        //遍历集合 进行数值和字符转换
        for (SpPaydivideSelectVo py:paydivideSelectVoList){
            if(py.getStatus()!=null){
                py.setStatusName(StatusEnum.getstatusName(py.getStatus()));
            }
        }

        return paydivideSelectVoList;
    }


}
