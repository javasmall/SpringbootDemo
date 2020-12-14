package com.restfuldemo.controller;

import com.restfuldemo.mapper.DogMapper;
import com.restfuldemo.pojo.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
public class TestController {

    @Autowired(required = false)
    DogMapper dogMapper;

    @GetMapping("dogs")
    public List<Dog> getDogs()
    {
        return  dogMapper.getAllDog();
    }

    @GetMapping("dogs/{id}")
    public Dog getDogById(@PathVariable("id") int id)
    {
        Dog dog=dogMapper.getDogById(id);
        return  dog;
    }
    @PostMapping("dogs")
    public boolean addDog(Dog dog)
    {
        return dogMapper.addDog(dog);
    }
    @PutMapping("dogs/{id}")
    public boolean updateDog(@PathVariable("id")int id,@RequestParam("name")String name,@RequestParam("age")int age)
    {

        Dog dog=dogMapper.getDogById(id);
        dog.setName(name);
        dog.setAge(age);
        return  dogMapper.updateDog(dog);
    }

    @DeleteMapping("dogs/{id}")
    public boolean deleteDog(@PathVariable("id") int id)
    {
        return  dogMapper.deleteDogById(id);
    }




}