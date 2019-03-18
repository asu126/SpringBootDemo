### 多对多关联关系

```sql92
drop table if exists tb_user;

-- 创建用户表
CREATE TABLE tb_user (
id INT PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(18),
loginname VARCHAR(18),
PASSWORD VARCHAR(18),
phone VARCHAR(18),
address VARCHAR(18)
);

-- 插入用户表测试数据
INSERT INTO tb_user (username,loginname,PASSWORD,phone,address)
VALUES('mayun','jack','123456','13600000000','hangzhou');


drop table if exists tb_article;

-- 创建商品表
CREATE TABLE tb_article(
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(18),
price DOUBLE,
remark VARCHAR(18)
);
-- 插入商品表测试数据
INSERT INTO tb_article(NAME,price,remark) VALUES('Python',108.9,'jdzz');

INSERT INTO tb_article(NAME,price,remark) VALUES('zryy',99.9,'jdzz');

INSERT INTO tb_article(NAME,price,remark) VALUES('bigdata',89.9,'jdzz');

INSERT INTO tb_article(NAME,price,remark) VALUES('tuijianxitong',69.9,'jdzz');


drop table if exists tb_order;

-- 创建订单表
CREATE TABLE tb_order(
id INT PRIMARY KEY AUTO_INCREMENT,
CODE VARCHAR(32),
total DOUBLE,
user_id INT,
FOREIGN KEY (user_id) REFERENCES tb_user(id)
);

-- 插入订单表测试数据
INSERT INTO tb_order(CODE,total,user_id)VALUES('20180315ORDER1212',388.6,1);
INSERT INTO tb_order(CODE,total,user_id)VALUES('20180315ORDER1213',217.8,1);


drop table if exists tb_item;
-- 创建中间表
CREATE TABLE tb_item(
order_id INT,
article_id INT,
amount INT,
PRIMARY KEY (order_id,article_id),
FOREIGN KEY (order_id) REFERENCES  tb_order(id),
FOREIGN KEY (article_id) REFERENCES tb_article(id)
);

-- 创建插入中间表数据
INSERT INTO tb_item(order_id,article_id,amount)VALUES(1,1,1);

INSERT INTO tb_item(order_id,article_id,amount)VALUES(1,2,1);

INSERT INTO tb_item(order_id, article_id,amount)VALUES(1,3,2);

INSERT INTO tb_item(order_id, article_id,amount)VALUES(2,4,2);

INSERT INTO tb_item(order_id, article_id,amount)VALUES(2,1,1);
```
