package com.zr.capital.service.impl;

import com.zr.capital.mapper.CapitalMapper;
import com.zr.capital.pojo.SignContractVo;
import com.zr.capital.pojo.TobelentListVo;
import com.zr.capital.pojo.overdueListSelectVo;
import com.zr.capital.pojo.overdueListShowVo;
import com.zr.capital.service.CapitalService;
import com.zr.meiju.ManagementStatusEnum;
import com.zr.util.ResultVO;
import com.zr.util.ResultVOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CapitalServiceImpl implements CapitalService {

   @Autowired
    private CapitalMapper capitalMapper;

    /**
     * 先查询idCode是否是在申请的状态之中
     * @param signContractVo
     * @return
     */
    @Override
    @Transactional
    public ResultVO signContract(SignContractVo signContractVo) {
        String idCode = capitalMapper.selectIdCodeFromJinjiansource(signContractVo.getIdCard());
        if(idCode == null){
            return ResultVOBuilder.error("500","身份证号码不存在，请核实后重试");
        }
        TobelentListVo tobelentListVo = new TobelentListVo();
        Integer row = capitalMapper.updateSignStatus(signContractVo);
        if(row < 1){
            return ResultVOBuilder.error("500","修改签约状态失败，请及时联系银行核对情况");
        }
        return ResultVOBuilder.success(signContractVo);
    }

    /**
     * 先去进件来源中查询是否有这个订单orderNum，之后修改待放款列表中放款金额和资方状态
     * @param tobelentListVo
     * @return
     */
    @Override
    @Transactional
    public ResultVO tobelentList(TobelentListVo tobelentListVo) {
        String idCode = capitalMapper.selectOrderNum(tobelentListVo.getOrderNumber());
        if(idCode == null){
            return ResultVOBuilder.error("500","该订单不存在");
        }
        Integer row = capitalMapper.updateTobelentList(tobelentListVo);
        if(row < 1){
            return ResultVOBuilder.error("500","修改放款金额失败，请及时联系银行核对情况");
        }
        tobelentListVo.setStatus(ManagementStatusEnum.getName(1));

        return ResultVOBuilder.success(tobelentListVo);
    }

   /**
     * 首先验证数据合法性，之后进行查询 在earliersettlement，overduelist
     * @param overdueListSelectVo
     * @return
     */
    @Override
    public ResultVO overdueList(overdueListSelectVo overdueListSelectVo) {
        //先查询这条数据存不存在
        overdueListShowVo overdueListShowVo = capitalMapper.overdueVerify(overdueListSelectVo.getIdCode(),overdueListSelectVo.getPhone());
        if(overdueListSelectVo == null){
            return ResultVOBuilder.error("500","您查询的逾期数据不存在");
        }
        overdueListShowVo =  capitalMapper.overdueFindAll(overdueListSelectVo);
        Integer row = 0;
        if(overdueListSelectVo != null){
            //修改数据
            row = capitalMapper.addOverdueListMsg(overdueListSelectVo);
        }
        //新增数据
        row = capitalMapper.updateOverdueListMsg(overdueListSelectVo);
        overdueListSelectVo.setReceiveStatus("接收成功");
        return ResultVOBuilder.success(overdueListShowVo);
    }
}
