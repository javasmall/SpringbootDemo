## Springboot 整合thymleaf

1. maven 中加入thymleaf依赖
2. 在resources/templates 目录下新建xxx.html
 ,html标签改为：
 
   `<html xmlns="http://www.w3.org/1999/xhtml"
         xmlns:th="http://www.thymeleaf.org">`
         
3. 在controller中映射该thymleaf，写一个方法String(modelandview) 返回“xxx”.同时可以在model中插入自己需要的值供自己使用详细看代码。
4. 注意就是取值按照类似el表达的语法。可以操作pojo，map，list等对象，对象套对象可以类推

5. 访问**localhost:8080/index** 和 **localhost:8080/index2**