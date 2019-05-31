## Springboot 整合redis

首先确保电脑上装了redis。最好能用redisDesktop查看一下数据情况

1. redis默认有16个分区（表），不配置情况默认用0个
2. 采取lettuce方式整合redis。lettuce性能更强点，喜欢jedis配合连接池也是线程安全的
3. redis 默认五种基本类型：String，set，hash，zset(有序集合),list
4. redis 有StringRedisTemplate和RedisTemplate
    * 对于StringRedisTemplate，继承RedisTemplate，只能存String类型的数据。如果你想用String类型存对象，你可以将对象转成json串存进去然后再取出来在转成对象。
    比较麻烦，存入的key和value都是字符型。
    * 对于RedisTemplate，默认是<object,object>类型。如果不做配置，他会对key和value默认
    序列化成二进制文件看不懂。不利于观察。一般重新配置redisTeamplate的一个bean。设置这个bean的key，value，
    以及hashkey等等的序列化方式。这样，你就可以在存入对象时候它自动帮你序列化成字符或者json。方便观察。
    
    
5. 对于整合redis你只需pom.xml引入相应依赖。在application.properties中填写相应配置
   账号密码之类。在重写RedisTemplate这个bean。配置他的序列化规则。注意就是注入bean的时候名称要和重写的名一样。因为这个对象是
   spring帮你生成好的给你使用。而如果你随便瞎起名字的话spring会根据原始重新生成对象。就没啥用了。
6. 更多的用法请百度。如果要存对象，那么pojo一定要继承序列化。否则无法存入redis。至于redis缓存，将在整合Springcache中介绍


可以参考springboot官方的整合redis
1. You can also register an arbitrary number of beans that implement LettuceClientConfigurationBuilderCustomizer for more advanced customizations. If you use Jedis, JedisClientConfigurationBuilderCustomizer is also available.
2. If you add your own @Bean of any of the auto-configured types, it replaces the default (except in the case of RedisTemplate, when the exclusion is based on the bean name, redisTemplate, not its type). By default, if commons-pool2 is on the classpath, you get a pooled connection factory.