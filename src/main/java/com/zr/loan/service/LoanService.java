package com.zr.loan.service;

import com.zr.loan.pojo.LoanDetailVo;
import com.zr.loan.pojo.LoanSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;
import com.zr.xinshenstatistics.util.ResultVo;

/**
 * Created by 94818 on 2019/7/6.
 */
public interface LoanService {
    ResultVO<AllRecords> queryPage(LoanSelectVo loansituationSelectVo);

    ResultVo<LoanDetailVo> queryByloginId(Integer loginId);
}
