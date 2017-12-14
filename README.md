# Spring-websocket
  传统的HTTP协议，一般通过向服务器发送请求，拉取数据实现半双工通信，缺点是服务器难以直接向浏览器下发消息，因此，websocket协议应运而生，可用于向建立连接的浏览器主动下发任意数据（PUSH）。本项目基于Spring平台，整合websocket协议，实现一个简易web聊天室的功能。主要特性如下:
  
  1.包含聊天室登录、退出的功能。登录时，浏览器自动向服务器发起websocket连接，退出时自动切断。
  
  2.登录后，用户可查看到聊天室在线的用户列表，我们在服务器上通过一个hashmap始终记录了当前在线的用户列表；

  3.登录的用户可以点击一个在线的其他用户，并给他发送消息，消息先提交给服务器，在通过服务器转发给另一端用户；
  
  4.支持群发消息的功能，使用时，服务器会将收到的消息群发给当前在线的所有用户;
  
  5.添加好友上线提醒和下线提醒的功能，当有好友上线或下线时自动通知所有其他在线人，不要刷新页面可看到实时在线用户列表。
  
  效果图：
  ![输入图片说明](http://git.oschina.net/uploads/images/2016/1121/155000_fbd7a93b_1110335.jpeg "在这里输入图片标题")
   
![输入图片说明](http://git.oschina.net/uploads/images/2016/1121/155008_ad2d6e7a_1110335.jpeg "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2016/1121/155016_df4cf908_1110335.jpeg "在这里输入图片标题")

![输入图片说明](http://git.oschina.net/uploads/images/2016/1121/155029_5e3afabc_1110335.jpeg "在这里输入图片标题")

### 附录：个人作品索引目录（持续更新）

#### 基本篇

1. [SpringMVC,Mybatis,Spring三大框架的整合实现增删改查](https://gitee.com/shenzhanwang/SSM)
2. [Struts2,Hibernate,Spring三大框架的整合实现增删改查](https://gitee.com/shenzhanwang/S2SH)
3. [Spring,SpringMVC和Hibernate的整合实现增删改查](https://gitee.com/shenzhanwang/SSH)
4. [Spring平台整合activiti工作流引擎实现OA开发](https://gitee.com/shenzhanwang/Spring-activiti)
5. [Spring发布与调用REST风格的WebService](https://gitee.com/shenzhanwang/Spring-REST)
6. [Spring整合Apache Shiro框架，实现用户管理和权限控制](https://gitee.com/shenzhanwang/Spring-shiro)
7. [使用Spring security做权限控制](https://gitee.com/shenzhanwang/spring-security-demo)

#### 中级篇

8. [Spring连接mongoDB数据库实现增删改查](https://gitee.com/shenzhanwang/Spring-mongoDB)
9. [Spring连接Redis实现缓存](https://gitee.com/shenzhanwang/Spring-redis)
10. [Spring连接图存数据库Neo4j实现增删改查](https://gitee.com/shenzhanwang/Spring-neo4j)
11. [Spring平台整合消息队列ActiveMQ实现发布订阅、生产者消费者模型（JMS）](https://gitee.com/shenzhanwang/Spring-activeMQ)
12. [Spring整合消息队列RabbitMQ实现四种消息模式（AMQP）](https://gitee.com/shenzhanwang/Spring-rabbitMQ)
13. Spring整合Jasig CAS框架实现单点登录（未开源）
14. Spring框架的session模块实现集中式session管理（未开源）
15. [Spring整合websocket实现即时通讯](https://gitee.com/shenzhanwang/Spring-websocket)
16. 使用Spring boot整合mybatis,rabbitmq,redis,mongodb实现增删改查（未开源）
17. [Spring MVC整合FastDFS客户端实现文件上传](https://gitee.com/shenzhanwang/Spring-fastdfs)

#### 高级篇

18. 搭建zookeeper集群提供目录服务（未开源）
19. 使用ubuntu+apache+SVN+SVNadmin+maven+Nexus+Hudson搭建持续集成环境（未开源）
20. Spring框架整合dubbo框架实现分布式服务治理（SOA架构）（未开源）
21. Spring框架整合dubbox实现微服务架构（MSA架构）（未开源）
22. 使用Spring Cloud实现微服务架构（MSA架构）（未开源）
23. 使用FastDFS搭建分布式文件系统（高可用、负载均衡）（未开源）
24. 搭建高可用nginx集群和Tomcat负载均衡（未开源）
25. 搭建可扩展的ActiveMQ高可用集群（未开源）
26. 实现Mysql数据库的主从复制、读写分离、分表分库、负载均衡和高可用（未开源）
27. 搭建高可用redis集群实现分布式缓存（未开源）
28. [Spring整合SolrJ实现全文检索](https://gitee.com/shenzhanwang/Spring-solr)
