package com.zr.pikou.mapper;

import com.zr.pikou.pojo.Approval;
import com.zr.pikou.pojo.ApprovalSelectVo;
import com.zr.pikou.pojo.ApprovalShowVo;
import com.zr.pikou.pojo.QueryBySelectVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ApprovalMapper {


    List<Approval> queryPage(ApprovalSelectVo approvalSelectVo);

    int queryCount(ApprovalSelectVo approvalSelectVo);

    List<ApprovalSelectVo> queryBankApprovalByCodes(List<String> orderNumberList);

    int updateStatus(List<ApprovalSelectVo> approvalSelectVoList);

    int insert(List<ApprovalSelectVo> approvalSelectVos);

    @Update("update approval set paymentAccount=#{paymentAccount},deductionResults=#{deductionResults}," +
            "issuanceOfWithholdingTime=#{issuanceOfWithholdingTime},deductible=#{deductible} where loanContractNum=#{loanContractNum}")
    int insertApproval(ApprovalShowVo approvalShowVo);


    @Update("update approval set status = 1 where loanContractNum = #{loanContractNum} ")
    int updateByStatus(ApprovalShowVo approvalShowVo);

    @Select("select * from approval where loanContractNum = #{loanContractNum}")
    List<String> queryByNum(String loanContractNum);


    List<Approval> queryBySelectPage(QueryBySelectVo queryBySelectVo);

    int queryBySelectCount(QueryBySelectVo queryBySelectVo);
}
