### java 导入源码

- https://blog.csdn.net/eclipsexys/article/details/24772223

- maven 导入指定目录包

```
<scope>system</scope>
<systemPath>/workspace/asu/eclipse-workspace/zookeeper/dubbox-dubbox-2.8.4/dubbo/target/dubbo-2.8.4.jar</systemPath>
```

- 源码打包

```
mvn install -Dmaven.test.skip=true
```
