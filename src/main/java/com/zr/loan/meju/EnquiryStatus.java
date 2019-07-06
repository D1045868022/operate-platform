package com.zr.loan.meju;

/**
 * Created by 94818 on 2019/6/18.
 */
public enum EnquiryStatus {
    WEIBAOJIA("未报价",0),YIBAOCUN("以保存",1),YITIJIAO("已提交",2),YISHENGHE("已审核",3),YIZUOFI("已作废",4);

    private final String statusName;
    private final Integer statusValue;

    private EnquiryStatus(String statusName, Integer statusValue)
    {
        this.statusName = statusName;
        this.statusValue = statusValue;
    }
    // 普通方法
    public static String getName(int statusValue) {
        for (EnquiryStatus c : EnquiryStatus.values()) {
            if (c.getStatusValue() == statusValue) {
                return c.statusName;
            }
        }
        return null;
    }
//    public String getStatusName() {
//        return statusName;
//    }

    public String getStatusName() {
        return statusName;
    }

    public Integer getStatusValue() {
        return statusValue;
    }
}
