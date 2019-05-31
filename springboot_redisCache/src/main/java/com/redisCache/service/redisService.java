package com.redisCache.service;

import com.redisCache.pojo.user;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class redisService {


    @Cacheable(value = "getalluser")
    public  List<user> getalluser()
    {
        /*
        假设数据从数据库查出啦。有这么两条
         */
        user user1=new user("bigsai","12345","man");
        user user2=new user("给我star","谢谢","man");
        List<user>list=new ArrayList<>();
        list.add(user1);
        list.add(user2);
        return list;
    }
    @Cacheable(value = "getuser",key = "#username")
    public user getuserbyname(String username)
    {
        user user=new user(username,"123","women");
        return user;
    }
}
