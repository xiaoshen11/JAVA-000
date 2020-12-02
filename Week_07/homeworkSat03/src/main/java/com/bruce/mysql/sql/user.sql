CREATE DATABASE  IF NOT EXISTS  `mall`  DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci ;

USE `mall`;

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '用户名',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `sex` tinyint(1) DEFAULT '0' COMMENT '性别 0未知 1男 2女',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间（毫秒数）',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间（毫秒数）',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `del_flag` bit(1) DEFAULT b'0' COMMENT '删除标识 0未删除 1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;