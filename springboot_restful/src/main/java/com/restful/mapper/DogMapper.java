package com.restfuldemo.mapper;

import com.restfuldemo.pojo.Dog;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DogMapper {


    @Select("select * from dog")
    List<Dog> getAllDog();

    @Select("select * from dog where id=#{id}")
    Dog getDogById(@Param("id") int id);

    @Insert("insert into dog (name,age) values (#{name},#{age})")
    boolean addDog(Dog dog);

    @Update("update dog set name=#{name},age=#{age} where id=#{id}")
    boolean updateDog(Dog dog);

    @Delete("delete  from dog where id=#{id}")
    boolean deleteDogById(int id);
}
