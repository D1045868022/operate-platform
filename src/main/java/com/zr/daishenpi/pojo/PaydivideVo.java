package com.zr.daishenpi.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 待审批列表 对应数据库整张表字段
 * Created by 李江涛 on 2019/7/9 0009.
 */
@Data
public class PaydivideVo {

    private Integer loginId;//注册表外键
    private Boolean payOffStatus;//是否已结清 ，0，未结清，1 已结清。
    private Integer amountSettlement;//结款金额  !!!!!!!
    private String paymentAccount;//收款账户
    private String startTime;//起止时间
    private String firstPayMentDate;//首次还款日
    private String name ;//借款人姓名 ------表userInfo   !!!!!!
    private String idCode;//借款人身份证号 -----表userInfo !!!!!!!!!!!!!
    private String payMentDate;//还款日
    private Integer paymentCycle;//借款期限 !!!!!!!!!!
    private String backBank;//默认还款银行
    private String agreement;//授权协议----默认值
    private Integer myCourse;//我的课程---借款用途---表paymentInformation---和lesson课程表 !!!!!!!!!!!!!
    private Integer status; //推送状态 value
    private Date classHours;//上课时间--用于岂止日期和还款日------表paymentInformation  !!!!!!!!!!
    private String bankCardAccount;//银行卡账号---表userRepay   !!!!!!!!!
    private Integer openingBank;//开户行----表userRepay    !!!!!!!
    private Date createTime;//创建时间
    private String createName;//创建人
    private Date updateTime;//修改时间
    private String updateName;//修改人


}
