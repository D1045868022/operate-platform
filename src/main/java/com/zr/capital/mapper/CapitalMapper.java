package com.zr.capital.mapper;

import com.zr.capital.pojo.OverdueListSelectVo;
import com.zr.capital.pojo.SignContractVo;
import com.zr.capital.pojo.TobelentListVo;
import com.zr.capital.pojo.overdueListShowVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CapitalMapper {

    Integer updateSignStatus(SignContractVo signContractVo);

    String selectIdCodeFromJinjiansource(String idCard);

    String selectOrderNum(String orderNumber);

    Integer updateTobelentList(TobelentListVo tobelentListVo);


    List<OverdueListSelectVo> queryByIdCodes(List<String> idCodes);

    int deleteByIdCodes(List<String> idCodes);

    int insertOverduList(List<OverdueListSelectVo> OverdueListSelectVoList);

    /**
     * 查询显示数据
     * @param OverdueListSelectVo
     * @return
     */
//    overdueListShowVo overdueFindAll(OverdueListSelectVo OverdueListSelectVo);

    /**
     *
     * @param OverdueListSelectVo
     * @return
     */
    Integer addOverdueListMsg(OverdueListSelectVo OverdueListSelectVo);

    Integer updateOverdueListMsg(OverdueListSelectVo OverdueListSelectVo);
}
