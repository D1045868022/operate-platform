package com.zr.loans.service;

import com.zr.loans.pojo.LoansituationSelectVo;
import com.zr.util.AllRecords;
import com.zr.util.ResultVO;

import java.util.List;

/**
 * Created by star on 2019/6/21.
 */
public interface LoansituationService {

/*    ResultVO<List<Loansituation>>  queryLoansituationById(Integer id);*/

    ResultVO<AllRecords> queryPage(LoansituationSelectVo loansituationSelectVo);
/*
    ResultVO<AllRecords> queryPage2(LoansituationSelectVo loansituationSelectVo);

    ResultVO queryAll();

    ResultVO queryAll2();
*/

}
