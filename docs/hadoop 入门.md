# hadoop 入门总结

### 配置
```
vim ~/.bashrc
export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
export HADOOP_HOME=/home/asu/hadoop-2.7.6
export HADOOP_MAPRED_HOME=$HADOOP_HOME 
export HADOOP_COMMON_HOME=$HADOOP_HOME 
export HADOOP_HDFS_HOME=$HADOOP_HOME 
export YARN_HOME=$HADOOP_HOME 
export HADOOP_COMMON_LIB_NATIVE_DIR=$HADOOP_HOME/lib/native 
export PATH=$PATH:$HADOOP_HOME/sbin:$HADOOP_HOME/bin 
export HADOOP_INSTALL=$HADOOP_HOME
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
