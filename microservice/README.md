# microservice

#### 项目介绍
一个方便大家学习的微服务架构DEMO，基于Spring Boot 2.0.4，OAuth2，JWT，Eureka，Zuul，包含注册中心、网关、鉴权等功能

实现功能：

1. 基于Eureka的注册中心
2. 基于OAuth2和JWT的认证授权服务器
3. 基于Zuul的带鉴权功能网关
4. 基于此DEMO可以轻松构建权限系统和业务系统

力求使用最简洁的代码实现这些功能，使学习者一目了然

如果需要指导，可以联系我 QQ：3142632531或加入QQ群：825552458一起讨论交流

可以有偿提供

1. 带详细注释的源码
2. 架构从0到1搭建思路文档
3. 安装、运行、编码的指导

只为让你快速学会微服务技术，为你节省学习成本(*^__^*) 

详细注释：

![](https://images.gitee.com/uploads/images/2018/0904/114821_183c98a6_1752359.png "屏幕截图.png")

补充文档图片
补充实现功能

#### 软件架构
软件架构说明


#### 安装教程

1. 使用Idea把项目Git到本地
2. Idea安装Lombok插件
3. 安装MySQL
4. 安装Redis
5. 安装Maven

#### 使用说明

1. 创建micro_services数据库，并执行micro_services.sql脚本
2. 修改lt-auth模块的application.yml文件中的redis和mysql地址
3. 修改lt-zuul模块的bootstrap.yml文件中的redis地址
4. 按顺序运行以下项目：lt-eureka,lt-auth,lt-zuul,lt-service-a,lt-service-b

#### 软件测试

1. 输入帐号密码获取JWT令牌
![输入图片说明](https://images.gitee.com/uploads/images/2018/0904/114235_f0861a71_1752359.png "屏幕截图.png")
2. 使用令牌通过网关访问服务A
![输入图片说明](https://images.gitee.com/uploads/images/2018/0904/114639_043df497_1752359.png "屏幕截图.png")

#### 应用说明

1. 构建权限系统：只需实现lt-auth中的com.ltmicro.auth.userdetails.service.UserService接口即可
2. 增加业务逻辑：只需和lt-service-a和lt-service-b一样，编写逻辑代码并注册到eureka即可
