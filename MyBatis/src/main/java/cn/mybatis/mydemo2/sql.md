### 一对多和多对一关系

```sql92
drop table if exists tb_clazz;

CREATE TABLE tb_clazz(
id INT PRIMARY KEY AUTO_INCREMENT,
CODE VARCHAR(18),
NAME VARCHAR(18)
);

INSERT INTO tb_clazz(CODE,NAME) VALUES('201803','计算机专业');

drop table if exists tb_student;

CREATE TABLE tb_student(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(18),
sex VARCHAR(18),
age INT,
clazz_id INT,
FOREIGN KEY(clazz_id) REFERENCES tb_clazz(id)
);

INSERT INTO tb_student (NAME,sex,age,clazz_id) VALUES('马云','男',23,1) ;
INSERT INTO tb_student (NAME,sex,age,clazz_id) VALUES('李飞飞','女',23,1) ;
INSERT INTO tb_student (NAME,sex,age,clazz_id) VALUES('马化腾','男',23,1) ;
INSERT INTO tb_student (NAME,sex,age,clazz_id) VALUES('柳青','女',23,1) ;
```
