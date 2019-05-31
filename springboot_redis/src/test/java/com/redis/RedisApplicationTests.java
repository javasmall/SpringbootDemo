package com.redis;

import com.redis.pojo.user;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {

    private final static Logger log= LoggerFactory.getLogger(RedisApplicationTests.class);
    @Autowired(required = false)
    RedisTemplate <String, Serializable> redisCacheTemplate;
    @Autowired(required = false)
    RedisTemplate redisTemplate;
    @Test
    public void contextLoads() {
    }
    @Test
    public void test1()
    {
        redisCacheTemplate.opsForValue().set("hello","heoolo");
        log.warn((String) redisCacheTemplate.opsForValue().get("hello"));

    }
    @Test
    public void test2()
    {
        user usr=new user("66","赛格","man");
        redisCacheTemplate.opsForValue().set("bigsai",usr);
        user user2=(user) redisCacheTemplate.opsForValue().get("bigsai");
        log.warn(user2.toString());
    }
    @Test
    public void test3()
    {
        user usr=new user("66","赛格","man");
        redisTemplate.opsForValue().set("bigsai33",usr);
        user user2=(user) redisTemplate.opsForValue().get("bigsai33");
        log.warn(user2.toString());
    }

}
