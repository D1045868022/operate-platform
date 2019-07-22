package com.zr.capital.mapper;

import com.zr.capital.pojo.SignContractVo;
import com.zr.capital.pojo.TobelentListVo;
import com.zr.capital.pojo.overdueListSelectVo;
import com.zr.capital.pojo.overdueListShowVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CapitalMapper {

    Integer updateSignStatus(SignContractVo signContractVo);

    String selectIdCodeFromJinjiansource(String idCard);

    String selectOrderNum(String orderNumber);

    Integer updateTobelentList(TobelentListVo tobelentListVo);

    /**
     * 验证逾期身份证号和电话是否存在
     * @param idCode
     * @param phone
     * @return
     */
    overdueListShowVo overdueVerify(@Param("idCode") String idCode,@Param("phone")  String phone);

    /**
     * 查询显示数据
     * @param overdueListSelectVo
     * @return
     */
    overdueListShowVo overdueFindAll(overdueListSelectVo overdueListSelectVo);

    /**
     *
     * @param overdueListSelectVo
     * @return
     */
    Integer addOverdueListMsg(overdueListSelectVo overdueListSelectVo);

    Integer updateOverdueListMsg(overdueListSelectVo overdueListSelectVo);
}
