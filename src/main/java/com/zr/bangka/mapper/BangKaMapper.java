package com.zr.bangka.mapper;


import com.zr.bangka.pojo.*;
import com.zr.earliersettlement.pojo.Earliersettlement;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BangKaMapper {

    List<BangKaShowVo> queryBankCardByCodes(List<String> orderNumberList);

    int updateStatus(List<BangKaShowVo> bangKaShowVoList);

    int insertBangKa(List<BangKaShowVo> bangKaShowVoList);

    List<BangKaVo> queryPage(BangKaSelectVo bangKaSelectVo);

    int queryCount(BangKaSelectVo bangKaSelectVo);

    @Select("select p.name,p.idCode,u.bankCardAccount,u.openingBank,u.bankPhone" +
            "from userrepay u LEFT JOIN paydivide p on p.loginId = u.loginId ")
    BangKaVo queryAll(BangKaAddVo bangKaAddVo);

    @Insert("insert into bangka (customerName,phone,bankCard,bankCardType,idCode) " +
            "values(#{name},#{idCode}),#{bankCardAccount},#{openingBank},#{bankPhone}")
        int bangKaAdd(BangKaAddVo bangKaAddVo);

    @Select("select * from bangka where bankCard = #{bankCard}")
    List<String> queryByNum(String bankCard);

    @Update("update bangka set cardStatus = 1,yanZhengStatus =1 where bankCard = #{bankCard} ")
    int update(BangKaShowVo bangKaShowVo);

    @Insert("insert into bangka (customerName,phone,bankCard,bankCardType,cardStatus,yanZhengStatus) " +
            "values(#{customerName},#{phone}),#{bankCard},#{bankCardType},#{cardStatus},#{yanZhengStatus}")
    int insert(BangKaShowVo bangKaShowVo);

    @Select("select * from bangka where idCode =#{idCode}")
    YinHangVo queryByCode(String idCode);

    @Select("select* from bangka")
    YinHangVo yinhangFindAll(YinHangVo yinHangVo);

    int deleteYinHang(YinHangVo yinHangVo);

    int addYinHang(YinHangVo yinHangVo);

    List<BangKaVo> queryBySelectVo(BangKaSelectVo bangKaSelectVo);
}


