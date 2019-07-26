package com.zr.mechant.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/6/9.
 */
@Data
public class MechantUpdateVo {
    //主表mechant
    /*private  Integer id;
    private  String  merchantName;
    private String merchantLegalPerson;
    private String merchantAddress;
    //@NotBlank(message = "商户名称不能为空")
    private String merchantDesc;
    private Integer foreignPhone;
    private Integer phone;

    //生成合同信息表mechant_generatinginformation
    private Integer bankCard;
    private String affiliatedBank;
    private String mailbox;
    private String province;
    private String jointLineNumber;
    private String lenderName;
    private  String lenderAddress;
    private  Integer lenderPhone;
    private  String  bankCity;

    //进度信息表mechant_speedprogress
//    private String management;
//    private String remark;
//    private Integer status;
//    private String statusName;
//    private String  code;
    //private Integer mechant_id;
     private List<Mechant_SpeedProgress> mechant_speedProgressList;

    //合同信息表 mechant_pic
   // private Date startTime  ;
   // private Date  endTime;
    private List<Mechant_Pic> mechantPicList;

    //配置信息表mechant_configure
    private  String landingAccount;
    private String landingPassword;
    private  Integer type;//商户类型名称
    private Integer isStore;//是否有门店
    private Integer isCreateStore;//是否能自建门店
    private Integer  isDeduction;//商户标识
    private  Integer isGrantAuthorization;//是否强制授权
    private Integer isActiveRepayment; //是否能主动还款
    private Integer education;  //教育
    private Integer renting;
    private Integer digital;
    private Integer blueWaterSource;
    private Integer huaBei;
    private Integer medicalBeauty;
    private Integer monthlyRentPayment;
    private Integer  channelMaintenance;
  //  private  Integer apartmentType;
//    private Integer isAddHousingResources;
//    private  Integer mechanismType;

    //资金信息表mechant_capital
    private Integer accountType;
    private String accountName;
    private  String openBank;
    private String bankAccount;
    private Integer advanceDays;
    private String oneRate;
    private String rate;

    //支付宝信息表mechant_zhifubao
    private String  zhifubaoAccount;
    private String zhifubaoPid;
    //其他信息表mechant_other
    //private String pic;
    private List<Mechant_Other> mechant_otherList;

    private Date createTime;
    private String createName;
    private Date updateTime;
    private String updateName;*/

    private String bankCard;//银行卡号
    private String lenderName;//出借人姓名
    private String affiliatedBank;//所属银行或支行
    private String lenderAddress;//出借人地址
    private String mailbox;//出借人邮箱
    private String lenderPhone;//出借人手机号
    private String province;//开户行所在省
    private String bankCity;//开户行所在市
    private String jointLineNumber;//开户行银联卡号

    //合同信息
    @Valid
    private List<Mechant_Pic> mechantPicList;//合同信息list

    //配置信息
    private String mechantaccount;//商户登录账号
    private String mechantpassword;//商户登录密码
    private Integer type;//商户类型名称
    private Integer isStore;//是否有门店
    private Integer isDeduction;//商户标识
    //    @NotNull(message = "至少要勾选一项")
//    private List<Integer> deductionList;//商户标识多选框
    private Integer channelMaintenance;//渠道维护 商务姓名


    //客户打款信息
    private Integer accountType;//账户类型 直接对应 对公
    private String accountName;//账户名称
    private String openBank;//开户银行
    private String bankAccount;//银行账号
    private Integer advanceDays;//宽限期天数
    private String oneRate;//机构利率
    private String rate;//费率

    //商户信息录入
    private Integer id;
    private String merchantName;
    private String merchantLegalPerson;
    private String merchantAddress;
    private String merchantDesc;
    private String foreignPhone;
    private String phone;
    private String mechantInvitationcode;//商户邀请码，四位不重复数字
    private Date createTime;
    private String createName;
    private Date updateTime;
    private String updateName;

}
