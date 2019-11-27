**项目说明** 
- 采用SpringBoot、MyBatis、框架，开发的一套api网关平台。
- 支持MySQL、Oracle、SQL Server、PostgreSQL等主流数据库
<br>

**具有如下特点** 
- 灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求
- 完善的数据权限，通过注解实现数据权限的控制
- 完善的XSS防范及脚本过滤，彻底杜绝XSS攻击
- 完善的CORS，支持跨域资源共享
- 完善的CSRF防御，彻底杜绝不可信的请求
- 完善的DDoS，防止多个位置的恶意攻击
- 支持分布式部署，session存储在redis中
- 友好的代码结构及注释，便于阅读及二次开发
- 引入quartz定时任务，可动态完成任务的添加、修改、删除、暂停、恢复及日志查看等功能
- 
<br>

**项目结构** 
```
api-gateway-parent
│ 
├─api-admin     api网关管理模块
│ 
├─api-core      api网关核心模块
│ 
├─api-monitor   api网关监控模块


```
**技术选型：** 
- 核心框架：Spring Boot 2.1
- 安全框架：Apache Shiro 1.4
- 视图框架：Spring MVC 5.0
- 持久层框架：MyBatis 3.5
- 定时器：Quartz 2.3
- 数据库连接池：Druid 1.1
- 日志管理：SLF4J 1.7、Log4j
<br>

**软件需求** 
- JDK1.8
- MySQL5.5+
- Maven3.0+
<br>
