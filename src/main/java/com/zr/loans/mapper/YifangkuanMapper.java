package com.zr.loans.mapper;

import com.zr.loans.pojo.Loans;
import com.zr.loans.pojo.YifangkuanSelectVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface YifangkuanMapper {

     List<Loans> queryPage(YifangkuanSelectVo yifangkuanSelectVo);

     Integer queryCount(YifangkuanSelectVo yifangkuanSelectVo);
}
