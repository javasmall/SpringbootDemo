## Springboot 整合redis

首先确保电脑上装了redis。最好能用redisDesktop查看一下数据情况

1. redis默认有16个分区（表），不配置情况默认用0个
2. 采取lettuce方式整合redis，因为lettuce性能高于jedis
3. redis 默认五种基本类型：String，set，hash，zset(有序集合),list
4. spring-cache 有@Cacheable      @CacheEvict     @CachePut注解三个
