### demo 数据库表
```sql92
create table person (
   id INT NOT NULL auto_increment,
   name VARCHAR(20) default NULL,
   age INT default 0,
   PRIMARY KEY (id)
);

create table customer (
   id INT NOT NULL auto_increment,
   name VARCHAR(20) default NULL,
   PRIMARY KEY (id)
);

create table orders (
   id INT NOT NULL auto_increment,
   sn VARCHAR(20) default NULL,
   remark  VARCHAR(20) default NULL,
   customer_id     INT  default NULL,
   PRIMARY KEY (id)
);

drop tables customer,orders, person;
```

### MyBatis 一些参考文档
- [一级缓存与二级缓存](https://mp.weixin.qq.com/s?__biz=MjM5NjQ5MTI5OA==&mid=2651747419&idx=2&sn=a7c25803179504b7232c0d6777fe4831&chksm=bd12ad168a65240095187adf72f82d0c7f2fcff52987e97fa385065eb63ff843e45dc896189e&mpshare=1&scene=23&srcid=0708i2B3zxQQJCepUAUUrZFw#rd)
- [一对一关系](http://www.mybatis.cn/archives/40.html)
- [一对多关联关系](http://www.mybatis.cn/archives/42.html)
- [多对多关联关系](http://www.mybatis.cn/archives/43.html)
