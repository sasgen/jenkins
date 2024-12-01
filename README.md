1. 一、仓库包含

1、常用的 jenkinsfile 方法、

2、常用的共享库方法

2. 二、使用方法

1、安装插件 Pipeline: Groovy 和 Pipeline: Groovy Libraries。

2、在全局配置中 Global Trusted Pipeline Libraries 配置，其中 Name 就是 jenkinsfile 中的共享库的应用

在 jenkinfile 中上来加载 @Library('demo-shared-library') _ 就是上面的 Name

2、在 jenkins 创建任务，选择 pipeline script from SCM,选择指定的仓库和分支

3、指定脚本路径，就是需要执行的脚本

3. 三、直接使用需要配置
1、jenkins上配置github的凭证，公钥钥放到github上，私钥要配置在jenkins中
2、jenkins上要配置共享库，系统管理>Global Trusted Pipeline Libraries中配置，并且设置名称为jenkins,因为目录api下面的jenkinsfile引用的名称就是jenkins
