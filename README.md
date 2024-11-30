一、仓库包含
1、常用的jenkinsfile方法、
2、常用的共享库方法

二、使用方法
1、安装插件Pipeline: Groovy 和 Pipeline: Groovy Libraries
2、在全局配置中Global Trusted Pipeline Libraries 配置，其中Name就是jenkinsfile中的共享库的应用
   在jenkinfile中上来加载 @Library('demo-shared-library') _ 就是上面的Name
2、在jenkins创建任务，选择pipeline script from SCM,选择指定的仓库和分支
3、指定脚本路径，就是需要执行的脚本
