package com.zr.pikou.service.ImpI;


import com.zr.meiju.BankCardEnum;
import com.zr.pikou.mapper.ApprovalMapper;
import com.zr.pikou.pojo.Approval;
import com.zr.pikou.pojo.ApprovalSelectVo;
import com.zr.pikou.pojo.ApprovalShowVo;
import com.zr.pikou.pojo.QueryBySelectVo;
import com.zr.pikou.service.ApprovalService;
import com.zr.sendrepaymentmessage.util.StatusEnum;
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
public class ApprovalServiceImpI implements ApprovalService {
    @Autowired
    private ApprovalMapper approvalMapper;

    @Override
    public ResultVO<AllRecords> queryPage(ApprovalSelectVo approvalSelectVo) {
        //查询数据
        List<Approval> approvalList = approvalMapper.queryPage(approvalSelectVo);
        //给扣款结果赋值中文
        for (Approval approval:approvalList){
            Integer deductionResults = approval.getDeductionResults()==true?0:1;
            approval.setStatusName(StatusEnum.getName(deductionResults));
        //给银行卡赋值中文
            approval.setBankName(BankCardEnum.getName(approval.getReimbursementAccountOpeningBank()));
        }
        //查询数量
        int count = approvalMapper.queryCount(approvalSelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(approvalSelectVo.getPageIndex());
        allRecords.setPageSize(approvalSelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(approvalList);
        return ResultVOBuilder.success(allRecords);

    }

    @Override
    @Transactional
    public ResultVO updateBankApproval(List<ApprovalSelectVo> approvalSelectVos) {
        List<String> orderNumberList = new ArrayList<>();
        //先验证数据是否存在，把存在了的数据删除掉
        for (ApprovalSelectVo approvalSelectVo:approvalSelectVos){
            orderNumberList.add(approvalSelectVo.getLoanContractNum());
        }
        List<ApprovalSelectVo>  approvalSelectVoList = approvalMapper.queryBankApprovalByCodes(orderNumberList);
        if(!CollectionUtils.isEmpty(approvalSelectVoList)){
            approvalMapper.updateStatus(approvalSelectVoList);
            approvalMapper.insert(approvalSelectVos);

        }else{
            approvalMapper.insert(approvalSelectVos);
        }
        return ResultVOBuilder.success(approvalSelectVos);
    }

    @Override
    @Transactional
    public ResultVO updateApproval(ApprovalShowVo approvalShowVo) {
        //验证数据是否存在
        List<String> loanContractNumList = approvalMapper.queryByNum(approvalShowVo.getLoanContractNum());
        if (CollectionUtils.isEmpty(loanContractNumList)){
            return ResultVOBuilder.error("修改数据不存在！","");
        }
        approvalMapper.updateByStatus(approvalShowVo);
        approvalMapper.insertApproval(approvalShowVo);
        return ResultVOBuilder.success(approvalShowVo);
    }

    @Override
    public ResultVO<AllRecords> queryBySelect(QueryBySelectVo queryBySelectVo) {
        //查询数据
        List<Approval> approvalList = approvalMapper.queryBySelectPage(queryBySelectVo);
        //给扣款结果赋值中文
        for (Approval approval:approvalList){
            Integer deductionResults = approval.getDeductionResults()==true?0:1;
            approval.setStatusName(StatusEnum.getName(deductionResults));
            //给银行卡赋值中文
            approval.setBankName(BankCardEnum.getName(approval.getReimbursementAccountOpeningBank()));
        }
        //查询数量
        int count = approvalMapper.queryBySelectCount(queryBySelectVo);
        //把当前页、每页大小、总页数、总条数、数据统一放入到AllRecords返回
        AllRecords allRecords = new AllRecords();
        allRecords.setPageIndex(queryBySelectVo.getPageIndex());
        allRecords.setPageSize(queryBySelectVo.getPageSize());
        allRecords.setTotalNumber(count);
        allRecords.resetTotalNumber(count);
        allRecords.setDataList(approvalList);
        return ResultVOBuilder.success(allRecords);

    }

}
