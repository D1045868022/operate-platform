package com.zr.loans.mapper;

import com.zr.loans.pojo.Loans;
import com.zr.loans.pojo.WodeshenpiSelectVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WodeshenpiMapper {

    List<Loans> queryPage(WodeshenpiSelectVo wodeshenpiSelectVo);

    Integer queryCount(WodeshenpiSelectVo wodeshenpiSelectVo);
}
