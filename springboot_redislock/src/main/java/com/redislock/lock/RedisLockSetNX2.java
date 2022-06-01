package com.redislock.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

@Component
public class RedisLockSetNX2 {

    private  static final Logger log= LoggerFactory.getLogger(RedisLockSetNX2.class);
    @Autowired(required = false)
    RedisTemplate redisLockTemplate;

    public  boolean getLock(String key,String value,long time){

        boolean getLock=redisLockTemplate.opsForValue().setIfAbsent(key,value,time, TimeUnit.SECONDS);
        log.info(Thread.currentThread().getName()+"获取锁："+getLock);
        return getLock;
    }
    public  boolean deleteLock(String key,String value){
        String valLocked= (String) redisLockTemplate.opsForValue().get(key);
        if(value.equals(valLocked)){//这个value 和 Redis中value相同
            boolean deleteLock=redisLockTemplate.delete(key);//假设不出意外
            log.info(Thread.currentThread().getName()+"删除锁成功");
            return true;
        }else {
            log.info(Thread.currentThread().getName()+"删除锁失败");
            return false;
        }
    }
}
