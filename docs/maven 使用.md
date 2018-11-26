### maven 使用

- 0. 安装 
```
sudo apt-get install maven
```

- 1. version 查看
```
mvn -version
```

- 2. 编译项目
```
mvn clean compile
```

- 3. 单元测试
```
mvn clean test
```

- 4. 项目打包
```
mvn clean package
```

mvn clean install


- 其他:pom文件中使用指定路径的方式配置jar包依赖
```
<dependencies>
...
    <dependency>
      <groupId>com.hadoopbook</groupId>
      <artifactId>ch02-mr-intro</artifactId>
      <version>4.0</version>
      <scope>system</scope>
      <systemPath>/workspace/asu/eclipse-workspace/hadoop-book/ch05-io/lib/ch02-mr-intro-4.0.jar</systemPath>
    </dependency>
...
</dependencies>
```
