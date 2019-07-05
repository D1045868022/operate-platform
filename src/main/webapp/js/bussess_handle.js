$(".add_bus").click(function () {
    //商户名称  商户法人 商户地址
    var merchantName,merchantLegalPerson,merchantAddress;
    //描述 对外电话 联系电话 出借人银行卡号 所属银行
    var merchantDesc,foreignPhone,phone,bankCard,affiliatedBank;
    //出借人邮箱 开户行所在省 开户银行联行号 出借人户名 出借人地址
    var mailbox,province,jointLineNumber,LenderName,lenderAddress;
    //出借人手机号  开户行所在市 资方 描述 状态值value 状态
    var lenderPhone,bankCity,management,remark,status,statusName;
    //机构码  开始时间 结束时间 商户账户 商户密码
    var code,startTime,endTime,landingAccount,landingPassword;
    //类型 类型value 是否有门店 是否有门店value 是否能自建门店 是否能自建门店value
    var typeName,type,isStoreName,isStore,isCreateStoreName,isCreateStore;
    //商户标识 商户标识value 是否强制授权 是否强制授权value
    var isDeductionName,isDeduction,isGrantAuthorizationName,isGrantAuthorization;
    //是否能主动还款 是否能主动还款value 教育 租房
    var isActiveRepaymentName,isActiveRepayment,education,renting;
    //数码  碧水源 花呗 医美 房租月付
    var digital,blueWaterSource,huaBei,medicalBeauty,monthlyRentPayment;
    // 渠道维护  账户类型 账户名称 开户银行 银行账号
    var channelMaintenance,accountType,accountName,openBank,bankAccount;
    //提前扣款天数  一次性服务费率 费率 支付宝账号 支付宝pid 其他资料信息
    var advanceDays,oneRate,rate,zhifubaoAccount,zhifubaoPid,pic;
    merchantName = $("#name").val();
    merchantLegalPerson = $("#contacts").val();
    merchantAddress = $("#bizAddrDetail").val();
    merchantDesc = $("#intro").val();
    foreignPhone = parseInt($("#contactTelNo").val());
    phone =  parseInt($("#tel").val());
    bankCard = parseInt($("#outBankCardNo").val());
    affiliatedBank = $("#outBankName").val();
    mailbox = $("#outEmail").val();
    province = $("#outbankprovince").val();
    jointLineNumber = $("#outBankNo").val();
    LenderName = $("#outBankIdName").val();
    lenderAddress = $("#outAddress").val();
    lenderPhone = parseInt($("#outPhoneNo").val());
    bankCity = $("#outbankcity").val();
    management = $("#ta_bm ").val();
    var _list = new Array();
    var _table_tr = $(".ta_bm tbody tr");
    if(_table_tr){
        var _sec,_third,_forth,_fif;
        for(var i = 0;i<_table_tr.length;i++){
            _sec =_table_tr.eq(i).find("td").eq(1).text();
            _third =_table_tr.eq(i).find("td").eq(2).text();
            _forth =_table_tr.eq(i).find("td").eq(3).text();
            _fif =_table_tr.eq(i).find("td").eq(4).text();
            _list[i]["management"] = _sec;
            _list[i]["remark"] = _third;
            _list[i]["status"] = _forth;
            _list[i]["statusName"] = _table_tr.eq(i).find("td").eq(3).attr("status");
            _list[i]["code"] = _fif;
        }
    }
    startTime = $("#startDate").val();
    endTime = $("#endDate").val();
    landingAccount = $("#account").val();
    landingPassword = $("#accountpwd").val();
    type = $("#bussinessType").val();
    if(type=="0"){
        typeName = "商户";
    }else{
        typeName = "代理";
    }
    isStore = $("#shopFlag").val();
    if(isStore=="1"){
        isStoreName = "是";
    }else{
        isStoreName = "否";
    }
    isCreateStore = $("#createShopFlag").val();
    if(isCreateStore=="1"){
        isCreateStoreName = "是";
    }else{
        isCreateStoreName = "否";
    }
    var deductionList = new Array();
    var j = 0;
    //循环所有选中的值
    $('input[name="sourceTpe"]:checked').each(function(index, element) {
        //追加到数组中
        isDeduction = parseInt($(this).val());
        switch(isDeduction){
            case 1:isDeductionName = "教育";
            break;
            case 2:isDeductionName = "租房";
                break;
            case 3:isDeductionName = "数码";
                break;
            case 4:isDeductionName = "碧水源";
                break;
            case 5:isDeductionName = "花呗";
                break;
            case 6:isDeductionName = "房租月付";
                break;
            case 7:isDeductionName = "医美";
                break;
        }
        deductionList[j]["isDeduction"] = isDeduction;
        deductionList[j]["isDeductionName"] = isDeductionName;
        j++;
    });
    isGrantAuthorization = $("#authFlag").val();
    if(isGrantAuthorization=="1"){
        isGrantAuthorizationName = "是";
    }else{
        isGrantAuthorizationName = "否";
    }
    isActiveRepayment = $("#paymentMethod").val();
    if(isActiveRepayment=="1"){
        isActiveRepaymentName = "是";
    }else{
        isActiveRepaymentName = "否";
    }
    //
    education = $("#").val();
    renting = $("#").val();
    digital = $("#").val();
    blueWaterSource = $("#").val();
    huaBei = $("#").val();
    medicalBeauty = $("#").val();
    monthlyRentPayment = $("#").val();
    //
    channelMaintenance = $("#channelManagerId").val();
    accountType = $("#accountType").val();
    accountName = $("#comName").val();
    openBank = $("#bankName").val();
    bankAccount = $("#bankAccountNo").val();
    advanceDays = $("#prepaymentDay").val();
    oneRate = $("#disposableFeeRate").val();
    rate = $("#serviceFeeRate").val();
    zhifubaoAccount = $("#alipayNo").val();
    zhifubaoPid = $("#alipayPid").val();
    pic = $(".upLoadImg").val();


})