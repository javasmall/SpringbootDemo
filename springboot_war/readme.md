## Springboot 打包成war

* step1： pom.xml中加入packge属性为war
* step2：添加servlet的支持，取消springboot内置tomcat
* step3：再启动函数中继承SpringBootServletInitializer。重写configure方法
* step4：maven packge打包部署

注意事项：
如果再开发过程中需要本地启动，把tomcat那段注释掉即可。其他部分不需要即可修改（servelt那部分也可以修改）

如果打包或者启动失败，记得及时clean内容。或者将test里面的注入等等注释掉
