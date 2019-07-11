package com.zr.shenpiliebiao.mapper;


import com.zr.shenpiliebiao.pojo.SpPaydivideSelectVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 待审批列表 mapper
 * 用 xml 文件实现sql查询  xml文件路径:resources/mybatis-mapper/SpPaydivideMapper
 * Created by 李江涛 on 2019/7/9 0009.
 */
@Mapper
public interface SpPaydivideMapper {


    //分页查询
    List<SpPaydivideSelectVo> queryByPage(SpPaydivideSelectVo spPaydivideSelectVo);

    //查询总条数
    int queryCount();

    //条件查询 根据id查询
    SpPaydivideSelectVo findById(Integer id);



}
