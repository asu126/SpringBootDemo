# hadoop 入门总结

### 配置

- sudo apt install openssh-server

```
vim ~/.bashrc
export JAVA_HOME=/usr/local/jdk/jdk1.8.0_201
export HADOOP_HOME=/home/su/hadoop-2.7.6
export HADOOP_MAPRED_HOME=$HADOOP_HOME 
export HADOOP_COMMON_HOME=$HADOOP_HOME 
export HADOOP_HDFS_HOME=$HADOOP_HOME 
export YARN_HOME=$HADOOP_HOME 
export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native 
export PATH=$PATH:$HADOOP_HOME/sbin:$HADOOP_HOME/bin 
export HADOOP_INSTALL=$HADOOP_HOME
```

###  配置文件
- hadoop-env.sh: 环境变量
- core-site.xml: hdfs,mr,yarn 等常用的IO配置
- hdfs-site.xml： Hadoop 守护进程配置项，包括datanode,namenode
- yarn-site.xml： yarn 收回进程配置项，宝包括资源管理器，web 应用代理服务器以及节点管理器
- marped-site.xml: MapReduce 守护进程的配置项，包括历史作业服务器

### 操作
```
- get namenode
hdfs getconf -namenodes

```

### 编译源码
```
$ mkdir units
$ javac -classpath `hadoop classpath` -d units WordCount.java
$ jar -cvf wc.jar -C units/ . 
```

### 上传测试文件
hadoop fs -mkdir /user/input1
hadoop fs -put file01 /user/input1
hadoop fs -put file02 /user/input1

### 运行
```
hadoop jar wc.jar org.myorg.WordCount /user/input1 /user/output_01
```

### 问题记录
- 1. Class org.myorg.Map not found：
加入`job.setJarByClass(WordCount.class);`
参考：https://blog.csdn.net/yunlong34574/article/details/21328245

- 2. WARN util.NativeCodeLoader: Unable to load native-hadoop

### 参考文档
- [hadoop 官方wiki](https://hadoop.apache.org/docs/stable/hadoop-project-dist/hadoop-common/SingleCluster.html)
- [hadoop 官方wiki 例子](https://wiki.apache.org/hadoop/WordCount)
- [易百教程](https://www.yiibai.com/hadoop/)
- [Apache Hadoop 入门教程](http://www.importnew.com/21536.html)
- [https://waylau.com/about-hadoop/](https://waylau.com/about-hadoop/)

### hadoop 学习
##### ch02-mr-intro
```
mvn package -DskipTests
cd ch02-mr-intro
hadoop jar target/ch02-mr-intro-4.0.jar MaxTemperature /user/ch02/input /user/ch02/output03

../ch02-mr-intro/target/ch02-mr-intro-4.0.jar
```

### Hadoop 模型
```
其他: Pig, Hive ...
Application: MapReduce, Spark, Tez ...
Compute: YARN
Storage: HDFS And HBase

```

### ch05 hadoop 的io 操作
- 数据完整性校验

```
hadoop fs -checksum /user/ch02/input/input.txt
/user/ch02/input/input.txt	MD5-of-0MD5-of-512CRC32C	00000200000000000000000049a9fad62798d4bf4f3cf23b356501d2
```
- run
```
echo "Text" | hadoop jar target/ch05-io-4.0.jar StreamCompressor org.apache.hadoop.io.compress.GzipCodec | gunzip
hadoop fs -put  /workspace/asu/eclipse-workspace/hadoop-book/ch05-io/src/test/resources/file.gz /user
hadoop jar target/ch05-io-4.0.jar FileDecompressor hdfs://localhost:9000/user/file.gz
cp lib/ch02-mr-intro-4.0.jar /workspace/asu/hadoop-2.7.6/share/hadoop/common/lib/
hadoop jar target/ch05-io-4.0.jar  MaxTemperatureWithCompression /user/ch02/input /user/ch02/output05
```

### ch16 Pig
##### 执行类型
- 本地模式（pig -x local）
- MapReduce 模式

##### 运行pig程序
数据需要多个MapReduce 过程才能完成
- 脚本：pig script.pig
- Grunt:
- 嵌入式方式

##### Hive
使用SQL 对放在HDFS中的大规模数据进行查询。

```
bin/schematool -dbType mysql -initSchema  --verbose
```

##### Spark
将作业与作业间的大规模数据放在内存中。

export M2_HOME=/home/su/workspace/apache-maven-3.5.3
export CLASSPATH=$CLASSPATH:$M2_HOME/lib
export PATH=$PATH:$M2_HOME/bin


#### 解压apache-hive 和 db-derby后初始化元数据

$ cd $HIVE_HOME
$ schematool -initSchema -dbType derby

```
# HIVE
export HIVE_HOME=/home/su/apache-hive-2.3.4-bin
export HIVE_CONF_DIR=/home/su/apache-hive-2.3.4-bin/conf
export PATH=$HIVE_HOME/bin:$PATH
export CLASSPATH=$CLASSPATH:/home/su/apache-hive-2.3.4-bin/lib/*:.

# DERBY
DERBY_HOME=/home/su/db-derby-10.14.2.0-bin
export PATH=$PATH:$DERBY_HOME/bin
export CLASSPATH=$CLASSPATH:$DERBY_HOME/lib/derby.jar:$DERBY_HOME/lib/derbytool

# ZOOKEEPER
export ZOOKEEPER_HOME=/home/su/zookeeper-3.4.12
export PATH=$PATH:$ZOOKEEPER_HOME/bin

# set java env
export JAVA_HOME=/usr/local/jdk/jdk1.8.0_201
export JRE_HOME=${JAVA_HOME}/jre
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib
export PATH=${JAVA_HOME}/bin:$PATH
```


