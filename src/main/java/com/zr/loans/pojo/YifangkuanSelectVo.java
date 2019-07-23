package com.zr.loans.pojo;

import com.zr.util.PageVo;
import lombok.Data;

import java.util.Date;

@Data
public class YifangkuanSelectVo extends PageVo {

    private Date letterTrialTimeStart;  //信审日期(开始)
    private Date letterTrialTimeEnd;  //信审日期(结束)
    private String merchant;//商户
    private Integer management;//资方
    private String idCode;//身份证号
    private String name;//客户姓名
    private Date loansTime;//放款时间
    private Integer status;

}
