
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
