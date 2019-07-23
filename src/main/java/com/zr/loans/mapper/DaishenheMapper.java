package com.zr.loans.mapper;

import com.zr.loans.pojo.DaishenheSelectVo;
import com.zr.loans.pojo.Loans;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DaishenheMapper {
    Integer queryCount(DaishenheSelectVo daishenheSelectVo);

    List<Loans> queryPage(DaishenheSelectVo daishenheSelectVo);
}
