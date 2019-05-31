## Springboot 整合devtools
热部署原理是两个classloader.当部分内容改变时候不影响整体配置就局部编译。省的全局编译很慢
1. 引入相应依赖
2. 在pom.xml中加入配置是必须的，详细看pom.xml
3. 对于静态资源和thymleaf 等，要在application.properties填写相应依赖
4. 在这种情况下 每次修改完 ctrl+F9可以手动编译，要比重启快很多
5. 如果需要完全自动编译。还需要：

   1. File-Settings-Compiler-Build Project automatically
   2. ctrl + shift + alt + /,选择Registry,勾上 Compiler autoMake allow when app running
6. 新建html，controller保存查看效果