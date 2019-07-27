package com.zr.mechant.mapper;
import com.zr.mechant.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by 86151 on 2019/4/22.
 */
@Mapper
@Repository
public interface MechantMapper {

    //查询数据库条数
    int queryCount(MechantSelectVo mechantSelectVo);

    //查询数据库数据
    List<MechantInfo> queryPage(MechantSelectVo mechantSelectVo);

    @Insert("insert into mechant (merchantName,merchantLegalPerson,merchantAddress,merchantDesc,foreignPhone,phone," +
            "businessType,mechantInvitationcode,isornocontract,setlimitMoney,status,bankCard,affiliatedBank,mailbox," +
            "province,jointLineNumber,LenderName,lenderAddress,lenderPhone,bankCity,mechanismType,mechantaccount,mechantpassword," +
            "isStore,education,renting,digital,blueWaterSource,huaBei,monthlyRentPayment,maintenancestaff,accountType,accountName" +
            ",openBank,bankAccount,advanceDays,oneRate,rate,createTime,createName,updateTime,updateName) value " +
            "(#{merchantName},#{merchantLegalPerson},#{merchantAddress},#{merchantDesc},#{foreignPhone}," +
            "#{phone},#{businessType},#{mechantInvitationcode},#{isornocontract},#{setlimitMoney},#{status},#{bankCard},#{affiliatedBank},#{mailbox},#{province}," +
            "#{jointLineNumber},#{LenderName},#{lenderAddress},#{lenderPhone},#{bankCity},#{mechanismType},#{mechantaccount},#{mechantpassword},#{isStore}," +
            "#{education}," +
            "#{renting},#{digital},#{blueWaterSource},#{huaBei},#{monthlyRentPayment},#{maintenancestaff},#{accountType}" +
            ",#{accountName},#{openBank},#{bankAccount},#{advanceDays}," +
            "#{oneRate},#{rate},#{createTime},#{createName},#{updateTime},#{updateName})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addMechant(MechantAddVo mechantAddVo);

    int addMp(List<Mechant_Pic> mp);


    int addMs(List<Mechant_SpeedProgress> ms);

    @Insert("insert into mechant_generatinginformation (bankCard,affiliatedBank,mailbox,province,jointLineNumber,LenderName,lenderAddress,lenderPhone,bankCity,createTime,createName,updateTime,updateName)" +
            " value(#{bankCard},#{affiliatedBank},#{mailbox},#{province},#{jointLineNumber},#{lenderName},#{lenderAddress},#{lenderPhone},#{bankCity},#{createTime},#{createName},#{updateTime},#{updateName}) ")
    int addMg(Mechant_Generatinginformation mg);

    @Insert("insert into mechant_zhifubao (zhifubaoAccount,zhifubaoPid)" +
            " value(#{zhifubaoAccount},#{zhifubaoPid}) ")
    int addMz(Mechant_ZhiFuBao mz);


    //根据id查询
    @Select("select merchantName from mechant where id=#{id}")
    Mechant queryMechantById(Integer id);

    //修改
    @Update("update mechant set mechantInvitationcode=#{mechantInvitationcode},merchantName=#{merchantName},merchantLegalPerson=#{merchantLegalPerson},phone=#{phone},foreignPhone=#{foreignPhone},merchantDesc=#{merchantDesc},merchantAddress=#{merchantAddress} where id=#{id}")
    int updateMechant(Mechant mechant);
    @Update("update mechant_configure set mechanismType=#{mechanismType},isAddHousingResources=#{isAddHousingResources},channelMaintenance=#{channelMaintenance},medicalBeauty=#{medicalBeauty},huaBei=#{huaBei},blueWaterSource=#{blueWaterSource},digital=#{digital},renting=#{renting},education=#{education},isActiveRepayment=${isActiveRepayment},isGrantAuthorization=#{isGrantAuthorization},isDeduction=#{isDeduction},isCreateStore=#{isCreateStore},isStore=#{isStore},type=#{type},landingPassword=#{landingPassword},landingAccount=#{landingAccount} where mechant_id=#{id}")
    int updataMp(Mechant_Configure mechant_configure);
//    @Update("update mechant_pic set startTime =#{startTime},endTime =#{endTime}")
    int updatePicList(List<Mechant_Pic>  mechant_picList);
//    @Update("update mechant_speedprogress set code=#{code},remark=#{remark},management=#{management},status=#{status}")
    int updateSpeedProgressList(List<Mechant_SpeedProgress> mechant_speedProgressList);

    @Update("update mechant_generatinginformation set bankCity=#{bankCity},lenderPhone=#{lenderPhone},lenderAddress=#{lenderAddress},lenderName=#{lenderName},jointLineNumber=#{jointLineNumber},province=#{province},mailbox=#{mailbox},affiliatedBank=#{affiliatedBank},bankCard=#{bankCard} where mechant_id=#{id}")
    int updateMg(Mechant_Generatinginformation mechant_generatinginformation);

//    @Update("update mechant_other set pic=#{pic}")
    int updateOtherList(List<Mechant_Other> mechant_otherList);

    @Update("update mechant_zhifubao set zhifubaoPid=#{zhifubaoPid},zhifubaoAccount=#{zhifubaoAccount} where mechant_id=#{id}")
    int updateMz(Mechant_ZhiFuBao mechant_zhiFuBao);

    @Update("update mechant_capital set rate=#{rate},oneRate=#{oneRate},advanceDays=#{advanceDays},bankAccount=#{bankAccount},openBank=#{openBank},accountType=#{accountType} where mechant_id=#{id}")
    int updateMcp(Merchant_Capital merchant_capital);

    //修改之前的查询数据
    @Select("SELECT " +
            "m.id,m.merchantName,m.merchantLegalPerson,m.merchantAddress,m.merchantDesc,m.foreignPhone,m.phone," +
            "g.bankCard,g.affiliatedBank,g.mailbox,g.province,g.jointLineNumber,g.lenderName,g.lenderAddress,g.lenderPhone,g.bankCity," +
            "o.landingAccount,o.landingPassword,o.type,o.isStore,o.isCreateStore,o.isDeduction,o.isGrantAuthorization,o.isActiveRepayment,o.education," +
            "o.renting,o.digital,o.blueWaterSource,o.huaBei,o.medicalBeauty,o.channelMaintenance,o.channelMaintenance,o.isAddHousingResources,o.mechanismType," +
            "c.accountType,c.openBank,c.bankAccount,c.advanceDays,c.oneRate,c.rate," +
            "z.zhifubaoAccount,z.zhifubaoPid" +
            "FROM mechant m " +
            "LEFT JOIN mechant_capital c ON m.id=c.mechant_id" +
            "LEFT JOIN mechant_configure o ON m.id=o.mechant_id" +
            "LEFT JOIN mechant_generatinginformation g ON m.id=g.mechant_id" +
            "LEFT JOIN mechant_zhifubao z ON m.id=z.mechant_id" +
            "WHERE m.id=#{id}")
    MechantUpdateVo queryMechantAllById(Integer id);

    @Select("select pic from mechant_other where mechant_id=#{mid}")
    List<Mechant_Other> queryOtherByMid(Integer mid);

    @Select("select management,remark,status,code from mechant_speedprogress where mechant_id=#{mid}")
    List<Mechant_SpeedProgress> querySpeedProgressByMid(Integer mid);

    @Select("select startTime,endTime from mechant_pic where mechant_id=#{mid}")
    List<Mechant_Pic> queryPicByMid(Integer mid);

    @Select("select merchantName from mechant where merchantName=#{merchantName}")
    Mechant queryMechantName(String merchantName);

    @Select("select mechantInvitationcode from mechant where mechantInvitationcode=#{mechantInvitationcode}")
    Mechant queryMeChantInvitationcode(String mechantInvitationcode);
}
