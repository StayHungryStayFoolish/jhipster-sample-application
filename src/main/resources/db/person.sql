show databases;

drop database if exists test;
create database test;

use test;
drop table if exists `person`;
create table `person` (
  `id`   bigint primary key AUTO_INCREMENT
  COMMENT '主键',
  `name` varchar(50)        DEFAULT NULL
  COMMENT '姓名',
  `age`  varchar(3)             DEFAULT NULL
  COMMENT '年龄',
  `sex`  varchar(10)             DEFAULT NULL
  COMMENT '性别'
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8;

show tables from test;
show full columns from person;
