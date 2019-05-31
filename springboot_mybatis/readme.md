## Springboot 整合mybatis

1. 在resources下的sql脚本复制。在navicat等sql执行（先创建表）
2. pom.xml加入编译配置（默认只编译resources的xml文件，不配置无法编译dao里的xml，这点和eclipse系列不太一样）
3. src创建对应文件夹。在application.properties中声明dao所在的包和mybatis映射pojo引用的包
4. 基于xml/注解两种方式实现mbatis的增删改查。dao的interface要加上@Mapper，注入的话加上@Autuwired,如果基于xml的注意格式关联；
5. 对于大部分和普通的都是没有关联的映射，那么pojo对象直接对应数据库的各个字段即可。但是如果遇到一对一，或者一对多的映射，大致的处理方式有两种
   1.联表查询，把所有字段都查询出来，然后在自定义的Map中配置各个对象属性。
   2. 嵌套查询，先查询1查第一个大对象，在大对象配置到pojo对象的时候再调用查询2（带上查询1查到的参数）
6. 对于一对一映射和一对多映射。最大的区别就是配置名称了。对于一对一的pojo对象
    
    ` <association property="POJO对象里面的名称" javaType="com.xxx>   </association>`
    
    而一对多
    ` <!-- ofType指定students集合中的对象类型 -->
            <collection property="master" ofType="com.mybatis.user">`
