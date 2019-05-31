## Springboot 整合redis

首先确保电脑上装了redis。最好能用redisDesktop查看一下数据情况

1. redis默认有16个分区（表），不配置情况默认用0个
2. 采取lettuce方式整合redis，因为lettuce性能高于jedis
3. redis 默认五种基本类型：String，set，hash，zset(有序集合),list
4. redis 有StringRedisTemplate和RedisTemplate
    * 对于StringRedisTemplate，继承redisTemplate，只能存String类型的数据。如果你想用String类型存对象，你可以将对象转成json串存进去然后再取出来在转成对象。
    比较麻烦。
    * 对于RedisTemplate，你可以重写他的方法，设置他的序列化方式。就可以自动存对象。他会自动帮你序列化成对应字符。（存在redis中的往往是你不认识的串串）
    当你再取的时候，他再反序列化成对应字符、对象。省的手动操作，所以推荐这种操作
5. 对于整合redis你只需pom.xml引入相应依赖。在application.properties中填写相应配置
   账号密码之类。在重写RedisTemplate这个bean。配置他的序列化规则
6. 更多的用法请百度。如果要存对象，那么pojo一定要继承序列化。否则无法存入redis。至于redis缓存，将在整合Springcache中介绍
