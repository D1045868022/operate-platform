package com.zr.earliersettlement.mapper;


import com.zr.earliersettlement.pojo.Earliersettlement;
import com.zr.earliersettlement.pojo.EarliersettlementSelectVo;
import com.zr.earliersettlement.pojo.EarliersettlementShowVo;
import com.zr.earliersettlement.pojo.Riskreserve_Capitalside;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EarliersettlementMapper {

    @Select("select * from riskreserve_capitalside")
    List<Riskreserve_Capitalside> queryAll();

    List<Earliersettlement> queryPage(EarliersettlementSelectVo earliersettlementSelectVo);

    int queryCount(EarliersettlementSelectVo earliersettlementSelectVo);

    int deleteEarliersettlement(List<EarliersettlementShowVo> earliersettlementShowVos);

    int insertEarliersettlement(List<EarliersettlementShowVo> earliersettlementShowVoList);

    List<EarliersettlementShowVo> queryByIdCodes(List<String> orderNumberList);

    List<Earliersettlement> queryBySelectVo(EarliersettlementSelectVo earliersettlementSelectVo);
}
