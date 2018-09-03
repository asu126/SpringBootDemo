CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `spring`;

DROP TABLE IF EXISTS `learn_resource`;

CREATE TABLE `learn_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `author` varchar(20) DEFAULT NULL COMMENT '作者',
  `title` varchar(100) DEFAULT NULL COMMENT '描述',
  `url` varchar(100) DEFAULT NULL COMMENT '地址链接',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1029 DEFAULT CHARSET=utf8;

insert  into `learn_resource`(`id`,`author`,`title`,`url`) values (999,'官方SpriongBoot例子','官方SpriongBoot例子','https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples');
insert  into `learn_resource`(`id`,`author`,`title`,`url`) values (1000,'龙果学院','Spring Boot 教程系列学习','http://www.roncoo.com/article/detail/124661');
insert  into `learn_resource`(`id`,`author`,`title`,`url`) values (1001,'嘟嘟MD独立博客','Spring Boot干货系列','http://tengj.top/');
insert  into `learn_resource`(`id`,`author`,`title`,`url`) values (1002,'后端编程嘟','Spring Boot视频教程','http://www.toutiao.com/m1559096720023553/');
insert  into `learn_resource`(`id`,`author`,`title`,`url`) values (1003,'程序猿DD','Spring Boot系列','http://www.roncoo.com/article/detail/125488');
insert  into `learn_resource`(`id`,`author`,`title`,`url`) values (1004,'纯洁的微笑','Sping Boot系列文章','http://www.ityouknow.com/spring-boot');
insert  into `learn_resource`(`id`,`author`,`title`,`url`) values (1005,'CSDN——小当博客专栏','Sping Boot学习','http://blog.csdn.net/column/details/spring-boot.html');
insert  into `learn_resource`(`id`,`author`,`title`,`url`) values (1006,'梁桂钊的博客','Spring Boot 揭秘与实战','http://blog.csdn.net/column/details/spring-boot.html');
insert  into `learn_resource`(`id`,`author`,`title`,`url`) values (1007,'林祥纤博客系列','从零开始学Spring Boot','http://412887952-qq-com.iteye.com/category/356333');
insert  into `learn_resource`(`id`,`author`,`title`,`url`) values (1028,'杜琪','关于Spring Boot的博客集合','http://www.jianshu.com/p/7e2e5e7b32ab');


CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT '123456',
  `address_id` int(11) DEFAULT NULL,
  `age` int(22) DEFAULT 18,
  `ROLE_USER` varchar(50) DEFAULT 'USER',
  `isActive` bool DEFAULT true,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `province` varchar(50) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO
    `user`
VALUES
    ('1', 'baby', 'baby', '123456', '1', '22', 'USER', true),
    ('2', 'kingboy', 'kingboy', '123456', '2', '24', 'USER', true),
    ('3', 'boy', 'boy', '123456', '3', '25', 'USER', true),
    ('4', 'kingbaby', 'kingbaby', '123456', '4', '30', 'USER', false);

INSERT INTO
    `address`
VALUES
    ('1', '北京', '北京'),
    ('2', '天津', '天津'),
    ('3', '安徽', '宿州'),
    ('4', '广东', '广州');

INSERT INTO
    `car`
VALUES
    ('1', 'green', '路虎', '1'),
    ('2', 'white', '奔驰', '2'),
    ('3', 'blue', '玛莎拉蒂', '4'),
    ('4', 'yellow', '兰博基尼', '4');

