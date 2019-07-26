package com.zr.tuihuo.mapper;


import com.zr.tuihuo.pojo.TuiHuo;
import com.zr.tuihuo.pojo.TuiHuoSelectVo;
import com.zr.tuihuo.pojo.TuiHuoShowVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TuiHuoMapper {

    List<TuiHuo> queryPage(TuiHuoSelectVo tuiHuoSelectVo);

    int queryCount(TuiHuoSelectVo tuiHuoSelectVo);

    @Update("update paydivide set refundAmount=#{refundAmount} where idCode=#{idCode}")
    int updateTuiHuo(TuiHuoShowVo tuwiHuoShowVo);

    @Select("select * from paydivide where idCode=#{idCode} ")
    List<String> queryByIdCode(String idCode);
}
