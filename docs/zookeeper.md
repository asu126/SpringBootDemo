### zookeeper

### ZooKeeper概述
Apache ZooKeeper是由集群（节点组）使用的一种服务，用于在自身之间协调，并通过稳健的同步技术维护共享数据。ZooKeeper本身是一个分布式应用程序，为写入分布式应用程序提供服务。

ZooKeeper提供的常见服务如下 :
- 命名服务 - 按名称标识集群中的节点。它类似于DNS，但仅对于节点。
- 配置管理 - 加入节点的最近的和最新的系统配置信息。
- 集群管理 - 实时地在集群和节点状态中加入/离开节点。
- 选举算法 - 选举一个节点作为协调目的的leader。
- 锁定和同步服务 - 在修改数据的同时锁定数据。此机制可帮助你在连接其他分布式应用程序（如Apache HBase）时进行自动故障恢复。
 - 高度可靠的数据注册表 - 即使在一个或几个节点关闭时也可以获得数据。

ZooKeeper所提供的服务主要是通过：数据结构+原语+watcher机制。

ZooKeeper可以为所有的读操作设置watch，这些读操作包括：exists()、getChildren()及getData()。watch事件是一次性的触发器，当watch的对象状态发生改变时，将会触发此对象上watch所对应的事件。

### zookeeper-端口说明
- 1、2181：对cline端提供服务
- 2、3888：选举leader使用
- 3、2888：集群内机器通讯使用（Leader监听此端口）

### 运行实例
##### zookeeeper 单实例安装
##### 运行 
- 1、下载 https://github.com/dubbo/dubbo-samples.git
- 2、Build the project

```
cd dubbo-samples-zookeeper
mvn clean package
# 运行服务提供方-- 生产者
mvn -Dexec.mainClass=org.apache.dubbo.samples.ProviderBootstrap exec:jav
# 运行客户端  -- 消费者
mvn -Dexec.mainClass=org.apache.dubbo.samples.ConsumerBootstrap exec:java
```

### 参考文档
- https://www.w3cschool.cn/zookeeper/zookeeper_overview.html
