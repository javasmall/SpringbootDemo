package com.redislock;

import com.redislock.lock.RedisLockSetNX;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedislockApplicationTests {

    private static  final Logger log= LoggerFactory.getLogger(RedislockApplicationTests.class);
    @Autowired(required = false)
    RedisLockSetNX redisLockSetNX;

    @Test
    public void setNXTest() throws InterruptedException {
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
            //获取锁 --> 执行逻辑 --> 释放锁
            //获取锁 锁名为lock1
            boolean lock=redisLockSetNX.getLock("lock1");
            if(lock){//获取锁成功
                try {//执行逻辑
                    log.info(Thread.currentThread().getName()+"获取锁成功，现在执行逻辑(假设2000ms耗时)");
                    Thread.sleep(2000);//假设干事干了2s
                }finally {//释放锁
                    redisLockSetNX.deleteLock("lock1");
                    log.info(Thread.currentThread().getName()+"删除锁");
                }
            }else {//获取锁失败 自旋竞争或者结束返回 根据业务来
                log.info(Thread.currentThread().getName()+"获取锁失败，持续竞争");
                Thread.sleep(500);//这里放大自旋的
                this.run();//此处在具体service中调用自己
            }
        }
    }

}
