package com.zr.loan.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 *
 * mhh
 * 贷款情况查询,查询vo
 */
@Data
public class LoanDetailVo {
    private int loginId;//外键
    //  联系人信息表 --userrelation
    private String familyContacts; //常用家庭联系人（第一联系人）
    private int relationsWithMe; //常用和我的关系（第一联系人）value
    private String relationsWithMeName; //常用和我的关系（第一联系人）name
    private String contactTelephone;//常用联系人电话（第一联系人）
    private String commonFamilyContacts;//家庭联系人（第二联系人）
    private int commonRelationsWithMe;//家庭联系人（第二联系人） 与我的关系value
    private String commonRelationsWithMeName;//家庭联系人（第二联系人） 与我的关系 name
    private String commonPhone;//家庭联系人 电话

    //还款银行卡登记表  --userrepay
    private int openingBank; //开户行 value
    private String openingBankName; //开户行 name
    private String bankCardAccount;//银行卡账号（还款账户）
    private String bankPhone;//（银行手机号）银行手机号

    //居住信息表 --userlive
    private int maritalStatus;//婚姻状况 value
    private String maritalStatusName;//婚姻状况 name
    private int liveStatus;//居住状态 value
    private String liveStatusName;//居住状态 name
    private int liveYear;//居住年限
    private String liveYearName;//居住年限
    private String detailedAddress;//详细地址


    //表paymentInformation---
    private int myCourse;//我的课程---借款用途---
    private String myCourseName; //
    private int amountSettlement;//结款金额  !!!!!!!
    private int amountInstallments;//分期金额
    private int paymentCycle;//借款期限 !!!!!!!!!!(还款周期) value
    private String paymentCycleName;//借款期限名称    name
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date classHours;//上课时间--用于岂止日期和还款日------表

    //userinfo 表 基本信息
    private String name ;//借款人姓名 ------idName;    //姓名
    private String idCode;//借款人身份证号 -----idNo;
    private String qqCode;//借款人身份证号 -----idNo;


    // 雪竹分期表 ---paydivide
    private String payMentDate;//还款日
    private String firstPayMentDate;//首次还款日
    private String paymentAccount;//收款账户
    private String startTime;//起止时间
    private String backBank;//默认还款银行
    private String agreement;//授权协议----默认值

    //影像资料pojo类对应表userPicture
    private String idPositive;//'身份证正面
    private String idOtherSide;//'身份证反面
    private String phoneIdPicture;//'手机身份证照片
    private String videoAuthentication;//'视频认证
    private String trainingContract;//'培训合同照片
    private String diploma;//'毕业证照片


}
