### 安装：解压apache-hive 和 db-derby后初始化元数据

$ cd $HIVE_HOME
$ schematool -initSchema -dbType derby
$ schematool -initSchema -dbType mysql

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
```


### 使用

1.

```
create table records (year STRING, temperature INT,quality INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY '\t';
select * from records;
load data local inpath '/tmp/sample.txt' overwrite into table records;
```

2. 

```
hive> select year, max(temperature)
    from records
    where temperature !=9999 AND quality in(0,1,4,5,9)
    group by year;
```

- https://blog.csdn.net/agent_x/article/details/78660341
- https://www.cnblogs.com/biehongli/p/7693598.html
