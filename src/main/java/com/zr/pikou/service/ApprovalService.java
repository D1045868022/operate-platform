package com.zr.pikou.service;


import com.zr.pikou.pojo.ApprovalSelectVo;
import com.zr.pikou.pojo.ApprovalShowVo;
import com.zr.pikou.pojo.QueryBySelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

import java.util.List;

public interface ApprovalService {


    ResultVO<AllRecords> queryPage(ApprovalSelectVo approvalSelectVo);

    ResultVO updateBankApproval(List<ApprovalSelectVo> approvalSelectVos);


    ResultVO updateApproval(ApprovalShowVo approvalShowVo);

    ResultVO<AllRecords> queryBySelect(QueryBySelectVo queryBySelectVo);
}
