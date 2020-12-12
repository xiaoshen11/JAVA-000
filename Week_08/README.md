# 周四作业

## **1.（**选做）分析前面作业设计的表，是否可以做垂直拆分。

### 

```
可以
之前设计了4张表，可以垂直拆分user、goods、t_order和order_detail三个库
```

![image-20201206194903681](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20201206194903681.png)





### **2.（必做）**设计对前面的订单表数据进行水平分库分表，拆分 2 个库，每个库 16 张表。并在新结构在演示常见的增删改查操作。代码、sql 和配置文件，上传到 Github。

https://github.com/xiaoshen11/JAVA-000/tree/main/Week_08/0804

用的ShardingSphere-proxy，配置如下

```
schemaName: sharding_db

dataSourceCommon:
  username: root
  password:
  connectionTimeoutMilliseconds: 30000
  idleTimeoutMilliseconds: 60000
  maxLifetimeMilliseconds: 1800000
  maxPoolSize: 50
  minPoolSize: 1
  maintenanceIntervalMilliseconds: 30000

dataSources:
  ds_0:
    url: jdbc:mysql://127.0.0.1:3306/ds_0?serverTimezone=UTC&useSSL=false
  ds_1:
    url: jdbc:mysql://127.0.0.1:3316/ds_1?serverTimezone=UTC&useSSL=false

rules:
- !SHARDING
  tables:
    t_order:
      actualDataNodes: ds_${0..1}.t_order_${0..15}
      tableStrategy:
        standard:
          shardingColumn: order_id
          shardingAlgorithmName: t_order_inline
      keyGenerateStrategy:
        column: order_id
        keyGeneratorName: snowflake
#    t_order_item:
#      actualDataNodes: ds_${0..1}.t_order_item_${0..1}
#      tableStrategy:
#        standard:
#          shardingColumn: order_id
#          shardingAlgorithmName: t_order_item_inline
#      keyGenerateStrategy:
#        column: order_item_id
#        keyGeneratorName: snowflake
#  bindingTables:
#    - t_order,t_order_item
  defaultDatabaseStrategy:
    standard:
      shardingColumn: user_id
      shardingAlgorithmName: database_inline
#  defaultTableStrategy:
#    none:

  shardingAlgorithms:
    database_inline:
      type: INLINE
      props:
        algorithm-expression: ds_${user_id % 2}
    t_order_inline:
      type: INLINE
      props:
        algorithm-expression: t_order_${order_id % 16}
#    t_order_item_inline:
#      type: INLINE
#      props:
#        algorithm-expression: t_order_item_${order_id % 2}
#
  keyGenerators:
    snowflake:
      type: SNOWFLAKE
      props:
        worker-id: 123
```



# 周六作业

## 1.（选做）列举常见的分布式事务，简单分析其使用场景和优缺点。

### XA(2pc、两阶段提交)  

使用场景：要求严格的一致性，比如金融交易类业务。

优点：保证数据强一致

缺点：对性能影响较大

适合短事务、低并发

#### 

### BASE(柔性事务) 

可以容忍一段时间的数据不一致，最终通过超时终止，调度补偿，等等方式，实现数据的最终状态一致性。 

使用场景：准实时或非实时的处理，比如T+1的各类操作，或者电商类操作

优点：对性能损耗小

缺点：会有一段时间数据不一致

适合高并发、长事务



## 2.（必做）基于 hmily TCC 或 ShardingSphere 的 Atomikos XA 实现一个简单的分布式事务应用 demo（二选一），提交到 Github。

```
https://github.com/xiaoshen11/JAVA-000/tree/main/Week_08/XA
https://github.com/xiaoshen11/JAVA-000/tree/main/Week_08/hmily-tcc-test
```

