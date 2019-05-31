package com.mybatis.dao;

import com.mybatis.pojo.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface userMapper {

    @Select("select * from user")
    List<user> getalluser();

    List<user> getalluserwithdog();
}
