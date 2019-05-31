package com.redisCache.controller;

import com.redisCache.pojo.user;
import com.redisCache.service.redisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class redisController {
    private  final static Logger log= LoggerFactory.getLogger(redisController.class);
    @Autowired(required = false)
    RedisTemplate redisTemplate;
    @Autowired(required = false)
    StringRedisTemplate stringRedisTemplate;
    @Autowired(required = false)
    redisService redisService;
    @GetMapping("getalluser")
    public List<user>getalluser()
    {
        return redisService.getalluser();
    }
    @GetMapping("getuser/{username}")
    public user getuser(@PathVariable String username)
    {
        return redisService.getuserbyname(username);
    }

}
