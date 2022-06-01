package com.redislock.controller;

import com.redislock.lock.RedisLockSetNX;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    private final Logger logger= LoggerFactory.getLogger(test.class);
    @Autowired(required = false)
    RedisTemplate redisLockTemplate;
    @Autowired(required = false)
    RedisLockSetNX redisLockSetNX;

    @GetMapping("test")
    public String setNXTest(){
        return redisLockSetNX.getLock("lock")+"";
    }
}
