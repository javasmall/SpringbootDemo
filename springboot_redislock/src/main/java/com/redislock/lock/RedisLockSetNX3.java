package com.redislock.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

@Component
public class RedisLockSetNX3 {

    private  static final Logger log= LoggerFactory.getLogger(RedisLockSetNX3.class);
    private static final String RELEASE_LOCK_LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

    @Autowired(required = false)
    RedisTemplate redisLockTemplate;

    public  boolean getLock(String key,String value,long time){

        boolean getLock=redisLockTemplate.opsForValue().setIfAbsent(key,value,time, TimeUnit.SECONDS);
        log.info(Thread.currentThread().getName()+"获取锁："+getLock);
        return getLock;
    }
    public  boolean deleteLock(String key,String value){
        DefaultRedisScript<Long>redisScript=new DefaultRedisScript<>(RELEASE_LOCK_LUA_SCRIPT,Long.class);
        long result= (long) redisLockTemplate.execute(redisScript, Collections.singletonList(key),value);
        log.info(Thread.currentThread().getName()+"删除锁："+result);
        return true;
    }
}
