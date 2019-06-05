package com.shiro.mapper;


import com.shiro.bean.student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface studentMapper {

    @Select("select  * from student where username=#{name}")
    student findByName(String name);
}
