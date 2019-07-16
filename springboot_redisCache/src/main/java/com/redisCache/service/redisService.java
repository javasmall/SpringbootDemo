package com.redisCache.service;

import com.redisCache.pojo.user;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class redisService {

    Logger logger= LoggerFactory.getLogger(redisService.class);

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
    //获取user  如果没有缓存将执行log
    @Cacheable(value = "getuser",key = "#username")
    public user getuserbyname(String username)
    {
        //假设该数据从mysql查询结果如下
        user user=new user(username,"123","women");
        logger.info("执行方法cacheable，从mysql查询");
        return user;
    }
     //更新user。每次都执行
    @CachePut(value = "getuser",key = "#username")
    public user updateuser(String username,String password)
    {
        //假设更新用户账号密码re
        user user=new user(username,"123","women");
        user.setPassword(password);
        logger.info("执行方法cacheput，再数据库更新返回");
        return user;
    }
    //删除缓存，其中condition可加可不加，本句意思是只有当姓名为bigsai
    @CacheEvict(value = "getuser",key = "#username")
    public String deleteuser(String username)
    {
         return "移除成功";
    }

}
