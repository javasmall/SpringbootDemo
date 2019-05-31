package com.redis.controller;

import com.redis.pojo.user;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class redisController {
    private  final static Logger log= LoggerFactory.getLogger(redisController.class);
    /*
    注入的名称要和RedisConfiguration的名称一致
    否则注入的默认的redisTemplate
    如果不喜欢序列化可以直接给config文件夹删除，哈哈
     */
    @Autowired(required = false)
    RedisTemplate redisCacheTemplate;
    //如果RedisTemplate redisTemplate就相当没配置序列化等
    @Autowired(required = false)
    StringRedisTemplate stringRedisTemplate;

    @Autowired(required = false)
    RedisTemplate redisTemplate;

    @GetMapping("test1")//StringRedistemplate  存String
    public String test1()
    {
        stringRedisTemplate.opsForValue().set("test1","hello赛赛");//再desttop中可以看到为中文串
        stringRedisTemplate.opsForValue().set("redis:test1","hello赛赛");//再desttop中可以看到为中文串
        redisTemplate.opsForValue().set("test1","hello赛赛");//再desttop中可以看到为二进制数字乱起八糟
        String val1=stringRedisTemplate.opsForValue().get("test1");
        //String va2=(String) redisCacheTemplate.opsForValue().get("test1");//不注释会报异常，因为Stingxxtemplate就是String没有序列化过。反序列化会报异常
        log.info(val1+" ");
        return val1+"      ";

    }
    @GetMapping("test2")//Redistemplate   存String
    public String test2()
    {
        redisCacheTemplate.opsForValue().set("bigsai222","hello赛赛2");
        String val1=stringRedisTemplate.opsForValue().get("bigsai222");//为  "hello赛赛2" 多个引号
        String va2=(String) redisCacheTemplate.opsForValue().get("bigsai222");//为  hello赛赛2  没有引号因为json反序列化
        log.info(val1+" "+va2);
        return val1+"      "+va2;
    }

    @GetMapping("test3")
    public user test3()
    {
        user user=new user("大佬","点个star谢谢！","man");
        redisCacheTemplate.opsForValue().set("user",user);
        user value=(user) redisCacheTemplate.opsForValue().get("user");
       log.info(redisCacheTemplate.hasKey("user")+"");//判断是否有键值对
       return value;
    }
}
