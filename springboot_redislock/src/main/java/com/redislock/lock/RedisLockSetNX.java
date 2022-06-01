package com.redislock.lock;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisLockSetNX {

    private  static final Logger log= LoggerFactory.getLogger(RedisLockSetNX.class);
    @Autowired(required = false)
    RedisTemplate redisLockTemplate;

    /**
     * 获取锁方法
     * @param key 获取锁的名称字符
     * @return
     */
    public  boolean getLock(String key){
        boolean getLock=redisLockTemplate.opsForValue().setIfAbsent(key,"666");
        log.info(Thread.currentThread().getName()+"获取锁："+getLock);
        return getLock;
    }

    /**
     * 删除锁的方法
     * @param key 删除对应的锁
     * @return
     */
    public  boolean deleteLock(String key){
        boolean deleteLock=redisLockTemplate.delete(key);
        return deleteLock;
    }

}
