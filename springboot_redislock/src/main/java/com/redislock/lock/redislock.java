package com.redislock.lock;


import lombok.Data;
import org.springframework.data.redis.core.RedisTemplate;
@Data
public class redislock {

    private  static String prefix ;
    private  static  long timeout;
    RedisTemplate redislockTeamplate;
    private String lockkey;
    private String lockvalue;

}
