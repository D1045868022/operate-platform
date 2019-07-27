package com.zr.yuqiliebiao.mapper;

import com.zr.yuqiliebiao.pojo.Overduelist;
import com.zr.yuqiliebiao.pojo.OverduelistVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YuqiMapper {
    List<Overduelist> queryPage(OverduelistVo overduelistVo);

    int queryCount(OverduelistVo overduelistVo);

    List<OverduelistVo> queryByIdCodes(List<String> idCodes);

    int deleteByIdCodes(List<String> idCodes);

    int insertOverduList(List<Overduelist> overduelistVo);

    List<Overduelist> queryBySelectVo(OverduelistVo overduelistVo);
}
