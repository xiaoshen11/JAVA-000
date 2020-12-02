# 周四作业

## 插入100w数据花费时间

### 批量插入，一次插入10000条

```
public int batchAdd() {
        //测试添加100w数据
        List<Order> list = new ArrayList<Order>(10000);
        Long m = System.currentTimeMillis();
        int result = 0;
        for (int j = 0; j < 100; j++) {

            for (int i = 0; i < 10000; i++) {
                Order order = new Order();
                order.setUserId(Long.valueOf(i));
                order.setActualAmount(Double.valueOf(i));
                order.setTotalAmount(Double.valueOf(i));
                order.setDiscountAmount(Double.valueOf(i));
                order.setOrderStatus(i/4);
                order.setCreateDate(m);
                order.setCreateBy(Long.valueOf(i));
                order.setDelFlag(false);
                list.add(order);
            }
            result += orderDao.batchInsert(list);
            list.clear();
        }
        Long end = System.currentTimeMillis();
        log.info("批量插入数据，花费时间为" + (end - m));
        return result;
    }
    执行结果为：批量插入数据，花费时间为107530
```

### 一次插入1000条

```
public int batchAdd() {
        //测试添加100w数据
        List<Order> list = new ArrayList<Order>(10000);
        Long m = System.currentTimeMillis();
        int result = 0;
        for (int j = 0; j < 1000; j++) {

            for (int i = 0; i < 1000; i++) {
                Order order = new Order();
                order.setUserId(Long.valueOf(i));
                order.setActualAmount(Double.valueOf(i));
                order.setTotalAmount(Double.valueOf(i));
                order.setDiscountAmount(Double.valueOf(i));
                order.setOrderStatus(i/4);
                order.setCreateDate(m);
                order.setCreateBy(Long.valueOf(i));
                order.setDelFlag(false);
                list.add(order);
            }
            result += orderDao.batchInsert(list);
            list.clear();
        }
        Long end = System.currentTimeMillis();
        log.info("批量插入数据，花费时间为" + (end - m));
        return result;
    }
批量插入数据，花费时间为210851
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