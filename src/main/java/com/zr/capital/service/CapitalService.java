package com.zr.capital.service;

import com.zr.capital.pojo.SignContractVo;
import com.zr.capital.pojo.TobelentListVo;
import com.zr.capital.pojo.OverdueListSelectVo;
import com.zr.util.ResultVO;

import java.util.List;

public interface CapitalService {


    ResultVO signContract(SignContractVo signContractVo);

    ResultVO tobelentList(TobelentListVo tobelentListVo);

    ResultVO overdueList(List<OverdueListSelectVo> overdueListSelectVo);
}
