package com.zr.capital.service;

import com.zr.capital.pojo.SignContractVo;
import com.zr.capital.pojo.TobelentListVo;
import com.zr.capital.pojo.overdueListSelectVo;
import com.zr.util.ResultVO;

public interface CapitalService {


    ResultVO signContract(SignContractVo signContractVo);

    ResultVO tobelentList(TobelentListVo tobelentListVo);

    ResultVO overdueList(overdueListSelectVo overdueListSelectVo);
}
