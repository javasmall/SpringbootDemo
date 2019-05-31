package com.druid.dao;

import com.druid.pojo.dog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface dogMapper {

    @Select("select * from dog")//不做配置情况找不到master，只能找数据库对应的字段
    List<dog>getalldog();

    //如果两个以上参数需要加param
    @Select("select * from dog where dogname=#{name} and dogtype=#{type}")
    List<dog>getdogbynametype(@Param("name") String dogname, @Param("type") String dogtype);

    List<dog> getdogbyType(String type);
}
