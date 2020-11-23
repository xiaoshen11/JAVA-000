# 表结构

## 用户表

```
CREATE TABLE `user` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

```

## 商品表

```
CREATE TABLE `goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) NOT NULL COMMENT '商品名称',
  `price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '单价',
  `stock` int(11) NOT NULL DEFAULT '0' COMMENT '库存',
  `size` varchar(20) DEFAULT NULL COMMENT '大小',
  `color` varchar(20) DEFAULT NULL COMMENT '颜色',
  `unit` varchar(20) DEFAULT NULL COMMENT '单位',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间（毫秒数）',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间（毫秒数）',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标识 0未删除 1已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品表';
```

## 订单表

```
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `total_amount` double(18,2) DEFAULT NULL COMMENT '订单金额',
  `discount_amount` double(18,2) DEFAULT NULL COMMENT '优惠金额',
  `actual_amount` double(18,2) NOT NULL COMMENT '实付金额',
  `order_status` int(2) NOT NULL DEFAULT '0' COMMENT '订单状态 0待支付 1支付成功 2取消订单 3退款',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间（毫秒数）',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间（毫秒数）',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标识 0未删除 1已删除',
  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';
```

## 订单详情表

```
CREATE TABLE `order_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `goods_id` bigint(20) NOT NULL COMMENT '商品id',
  `goods_num` int(2) NOT NULL DEFAULT '0' COMMENT '商品数量',
  `total_amount` double(18,2) DEFAULT NULL COMMENT '订单金额',
  `discount_amount` double(18,2) DEFAULT NULL COMMENT '优惠金额',
  `actual_amount` double(18,2) NOT NULL COMMENT '实付金额',
  `create_date` bigint(20) DEFAULT NULL COMMENT '创建时间（毫秒数）',
  `update_date` bigint(20) DEFAULT NULL COMMENT '更新时间（毫秒数）',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `del_flag` bit(1) NOT NULL DEFAULT b'0' COMMENT '删除标识 0未删除 1已删除',
  PRIMARY KEY (`id`),
  KEY `order_id_idx` (`order_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单详情表';
```

