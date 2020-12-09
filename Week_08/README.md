# 周四作业

## **1.（**选做）分析前面作业设计的表，是否可以做垂直拆分。

### 

```
可以
之前设计了4张表，可以垂直拆分user、goods、t_order和order_detail三个库
```

![image-20201206194903681](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20201206194903681.png)





### **2.（必做）**设计对前面的订单表数据进行水平分库分表，拆分 2 个库，每个库 16 张表。并在新结构在演示常见的增删改查操作。代码、sql 和配置文件，上传到 Github。

```

```



### 一条一条插入

```
public int batchAdd() {
        Long m = System.currentTimeMillis();
        int result = 0;
        for (int i = 0; i < 1000000; i++) {
            Order order = new Order();
            order.setUserId(Long.valueOf(i));
            order.setActualAmount(Double.valueOf(i));
            order.setTotalAmount(Double.valueOf(i));
            order.setDiscountAmount(Double.valueOf(i));
            order.setOrderStatus(i/4);
            order.setCreateDate(m);
            order.setCreateBy(Long.valueOf(i));
            order.setDelFlag(false);
            result += orderDao.insert(order);
        }
        Long end = System.currentTimeMillis();
        log.info("单条插入数据，花费时间为" + (end - m));
        return result;
    }
   执行结果为： 20分钟才跑了1w2的数据。
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

```

