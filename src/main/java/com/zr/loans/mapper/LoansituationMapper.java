package com.zr.loans.mapper;

import com.zr.loans.pojo.Loans;
import com.zr.loans.pojo.LoansituationSelectVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by star on 2019/6/21.
 */
@Mapper
@Repository
public interface LoansituationMapper {


    List<Loans> queryPage(LoansituationSelectVo loansituationSelectVo);
    Integer queryCount(LoansituationSelectVo loansituationSelectVo);
}
