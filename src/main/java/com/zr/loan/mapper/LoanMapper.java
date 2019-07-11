package com.zr.loan.mapper;

import com.zr.loan.pojo.LoanDetailVo;
import com.zr.loan.pojo.LoanSelectVo;
import com.zr.loan.pojo.LoanShowVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by 94818 on 2019/7/6.
 */
@Mapper
public interface LoanMapper {

    List<LoanShowVo> queryPage(LoanSelectVo loansituationSelectVo);

    int queryCount(LoanSelectVo loansituationSelectVo);

    LoanDetailVo queryByloginId(Integer loginId);
}
