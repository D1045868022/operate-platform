package com.zr.mechant.model;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class MechantAddVo {
    //生成合同信息
    @NotNull(message = "请填写卡号")
    private String bankCard;//银行卡号
    @NotBlank(message = "出借人姓名不能为空")
    private String lenderName;//出借人姓名
    @NotBlank(message = "所属银行或支行不能为空")
    private String affiliatedBank;//所属银行或支行
    @NotBlank(message = "出借人地址不能为空")
    private String lenderAddress;//出借人地址
    private String mailbox;//出借人邮箱
    @NotBlank(message = "出借人手机号不能为空")
    private String lenderPhone;//出借人手机号
    @NotBlank(message = "开户行所在省不能为空")
    private String province;//开户行所在省
    @NotBlank(message = "开户行所在市不能为空")
    private String bankCity;//开户行所在市
    @NotBlank(message = "开户行银联卡号不能为空")
    private String jointLineNumber;//开户行银联卡号

    //合同信息
    @Valid
    private List<Mechant_Pic> mechantPicList;//合同信息list

    //配置信息
    @NotBlank(message = "商户登录账号不能为空")
    private String mechantaccount;//商户登录账号
    @NotBlank(message = "商户登录密码不能为空")
    private String mechantpassword;//商户登录密码
    @NotNull(message = "商户类型名称不能为空")
    private Integer type;//商户类型名称
    @NotNull(message = "是否有门店不能为空")
    private Integer isStore;//是否有门店
    private Integer isDeduction;//商户标识
//    @NotNull(message = "至少要勾选一项")
//    private List<Integer> deductionList;//商户标识多选框
    @NotNull(message = "至少要选择一个")
    private Integer channelMaintenance;//渠道维护 商务姓名


    //客户打款信息
    private Integer accountType;//账户类型 直接对应 对公
    @NotBlank(message = "账户名称不能为空")
    private String accountName;//账户名称
    @NotBlank(message = "开户银行不能为空")
    private String openBank;//开户银行
    @NotBlank(message = "银行账号不能为空")
    private String bankAccount;//银行账号
    @NotNull(message = "宽限期天数不能为空")
    private Integer advanceDays;//宽限期天数
    @NotBlank(message = "机构利率不能为空")
    private String oneRate;//机构利率
    @NotBlank(message = "费率不能为空")
    private String rate;//费率

    //商户信息录入
    private Integer id;
    @NotBlank(message = "商户名称不能为空")
    private String merchantName;
    @NotBlank(message = "商户法人不能为空")
    private String merchantLegalPerson;
    @NotBlank(message = "商户地址不能为空")
    private String merchantAddress;
    @NotBlank(message = "商户描述不能为空")
    private String merchantDesc;
    @NotBlank(message = "对外电话不能为空")
    private String foreignPhone;
    @NotBlank(message = "电话不能为空")
    private String phone;
    @NotBlank(message = "商户邀请码不能为空")
    private String mechantInvitationcode;//商户邀请码，四位不重复数字
    private Date createTime;
    private String createName;
    private Date updateTime;
    private String updateName;

/*
    //进度信息表mechant_speedprogress
//    private String management;
//    private String remark;
//    private Integer status;
//    private String statusName;
//    private String  code;
    //private Integer mechant_id;
    private List<Mechant_SpeedProgress> mechantSpeedProgressList;

    //合同信息表 mechant_pic


    //配置信息表mechant_configure
    private String landingAccount;
    private String landingPassword;


    private Integer isCreateStore;//是否能自建门店

    private Integer isGrantAuthorization;//是否强制授权
    private Integer isActiveRepayment; //是否能主动还款
    private Integer education;  //教育
    private Integer renting;
    private Integer digital;
    private Integer blueWaterSource;
    private Integer huaBei;
    private Integer medicalBeauty;
    private Integer monthlyRentPayment;

    //  private  Integer apartmentType;
//    private Integer isAddHousingResources;
//    private  Integer mechanismType;

    //资金信息表mechant_capital








    //支付宝信息表mechant_zhifubao
    private String zhifubaoAccount;
    private String zhifubaoPid;
    //其他信息表mechant_other
    //private String pic;
    private List<Mechant_Other> mechantOtherList;

    private Date createTime;
    private String createName;
    private Date updateTime;
    private String updateName;
*/


}
