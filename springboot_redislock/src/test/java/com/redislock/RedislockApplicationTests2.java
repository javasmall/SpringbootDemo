package com.redislock;

import com.redislock.lock.RedisLockSetNX2;
import com.redislock.lock.RedisLockSetNX3;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedislockApplicationTests2 {

    private static  final Logger log= LoggerFactory.getLogger(RedislockApplicationTests2.class);
    @Autowired(required = false)
    RedisLockSetNX3 redisLockSetNX3;

    @Test
    public void setNXTest1() throws InterruptedException {
        //模拟service1
        Thread service1=new Thread(new Service());
        Thread service2=new Thread(new Service());
        service1.start();
        service2.start();

        service1.join();//这里test特殊等待主线程
        service2.join();
    }

    class Service implements  Runnable{

        @SneakyThrows
        @Override
        public void run() {
            //获取锁 --> 干事 --> 释放锁
            String uuid= UUID.randomUUID().toString();
            boolean lock=redisLockSetNX3.getLock("lock1",uuid,16);
            if(lock){
                try {
                    log.info(Thread.currentThread().getName()+"获取锁成功，现在拿着锁干事");
                    for(int i=0;i<7;i++){
                        log.info(Thread.currentThread().getName()+"干事ing，过去2s了");
                        Thread.sleep(2000);//假设干事干了2s 一次干了8s总共
                    }
                }finally {
                    redisLockSetNX3.deleteLock("lock1",uuid);
                }
            }else {
                //获取锁失败，持续竞争，下一秒竞争
                Thread.sleep(1000);//这里放大自旋的
                this.run();//此处在具体service中调用自己
            }
        }
    }
}
