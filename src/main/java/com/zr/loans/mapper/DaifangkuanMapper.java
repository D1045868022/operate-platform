package com.zr.loans.mapper;

import com.zr.loans.pojo.Loans;
import com.zr.loans.pojo.DaiFangKuanSelectVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @authot 谢烽
 * @create 2019 - 06 - 21 - 16:35
 */
@Mapper
@Repository
public interface DaifangkuanMapper {

    //根据条件查询
    List<Loans> findAll(DaiFangKuanSelectVo daiFangKuanSelectVo);

    //查询总数量
    Integer queryCount();
}
