package com.zr.yuqiliebiao.pojo;

import com.zr.util.PageVo;
import lombok.Data;

/**
 * Created by jiangping on 2019/7/23.
 */
@Data
public class OverduelistVo extends PageVo {
    private String idCode;//	varchar'身份证号'
    private String phone;//	int'手机号'
    private String name; //客户姓名

}
