package com.zr.mechant.model;




import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Administrator on 2019/6/3.
 */
@Data
public class Mechant_Pic {
    private Integer id;
//    @NotNull(message = "起始时间不能为空")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
//    @NotNull(message = "结束时间不能为空")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date  endTime;
    private Integer picId;
    private Integer mechantId;//外键
}
