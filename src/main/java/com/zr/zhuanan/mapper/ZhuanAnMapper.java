package com.zr.zhuanan.mapper;


import com.zr.zhuanan.pojo.ZhuanAnSelectVo;
import com.zr.zhuanan.pojo.ZhuanAnShowVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ZhuanAnMapper {

    @Select("select * from project where managementProjectCode =#{managementProjectCode}")
    ZhuanAnShowVo queryByCode(@Param("managementProjectCode") String managementProjectCode);

    @Select("select * from project")
    ZhuanAnShowVo distributionSchemeFindAll(ZhuanAnSelectVo zhuanAnSelectVo);

    int addDistributionScheme(ZhuanAnSelectVo zhuanAnSelectVo);

    int deleteDistributionScheme(ZhuanAnSelectVo zhuanAnSelectVo);
}
