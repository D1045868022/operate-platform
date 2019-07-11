package com.zr.daishenpi.mapper;

import com.zr.daishenpi.pojo.PaydivideSelectVo;
import com.zr.daishenpi.pojo.PaydivideUpdateStatusVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 待审批列表 mapper
 * 用 xml 文件实现sql查询  xml文件路径:resources/mybatis-mapper/PaydivideMapper
 * Created by 李江涛 on 2019/7/9 0009.
 */
@Mapper
public interface PaydivideMapper {


    //分页查询
    List<PaydivideSelectVo> queryByPage(PaydivideSelectVo paydivideSelectVo);

    //查询总条数
    int queryCount();

    //条件查询 根据id查询
    PaydivideSelectVo findById(Integer id);

    //修改状态  status 字段
    void updateSpStatus(PaydivideUpdateStatusVo paydivideUpdateStatusVo);
}
