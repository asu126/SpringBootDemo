### hbase

- 安装
```
$ http://mirrors.shu.edu.cn/apache/hbase/stable/
```

JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64


- 运行

```
cd /home/su/hbase-1.2.6.1
bin/start-hbase.sh
bin/hbase shell
```

- 简单用法

```
create "test", 'data', 'info'
list
put 'test', "row1", "data:1", "value1"
put 'test', "row2", "data:2", "value2"
put 'test', "row3", "data:1", "value1"
put 'test', "row3", "data:2", "value2"
get 'test', "row3"
drop 'test'
```

安装参考：
- [1-csdn](https://blog.csdn.net/flyfish111222/article/details/51893096)
- [中文翻译](http://abloz.com/hbase/book.html) 

