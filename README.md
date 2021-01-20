# 「Java进阶训练营-第0期」毕业作业




## 1)JVM

Java是通过不同的平台有不同版本的JVM来实现跨平台的。

三类加载器：启动类加载器（BootstrapClassLoader）、扩展类加载器（ExtClassLoader）、应用类加载器（AppClassLoader）

还可以自定义类加载器，继承 ClassLoader 就可以了。

JVM内存模型：堆、线程栈、本地方法栈、程序计数器、非堆（元数据、常量池）

JVM启动参数：-Xmx 最大堆内存， -Xms 堆内存初始化大小， -Xmn 年轻代大小

垃圾回收器：Serial GC、Parallel GC、CMS、G1、ZGC、ShenandoahGC 

JVM图形化工具：jconsole、jvisualvm、VisualGC、jmc

JVM问题分析：1.高分配速率 2.过早提升

![image-20210201004142771](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210201004142771.png)



## 2)NIO

IO 分为 BIO（阻塞IO） NIO（非阻塞IO） AIO（异步IO）

最开始jdk只支持BIO，这样如果有IO操作比较耗时，就会一直阻塞线程。

jdk1.4之后，引入NIO框架，它是基于管道来执行操作，一个线程的写请求在管道执行，不需要等写请求执行完，这个线程可以去做别的事，不用一直等在这。

AIO是jdk1.7之后引入的，是基于事件和回调机制实现，应用操作之后会直接返回，不会堵塞在那里，当后台处理完成，操作系统会通知相应的线程进行后续的操作。

Netty的一个NIO网络框架，高性能，低延迟。

Netty基于事件驱动。

![image-20210201230054041](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210201230054041.png)


## 3) 并发编程

竞争压力不大的时候，可以用CAS，无锁性能比较好。

压力大的话，CAS自旋比较消耗性能。

线程的状态：start、runable、running、waiting、time_wating、terminated。

Java的并发包 JUC 里面有很多工具：锁、原子类、线程池、工具类、集合类。

线程池复用线程，记得清理ThreadLocal，考虑好用什么阻塞队列、拒绝策略。

synchronized：粒度粗，不用显示解锁

lock：粒度细，需要显示加锁解锁

线程协作：CyclicBarrier、Semaphore、CountDownLatch、join

线程安全集合：

CopyOnWriteArrayList 适合读多写少

ConcurrentHashMap 用来替代hashmap，注意1.7和1.8的区别



![image-20210202002710762](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210202002710762.png)

## 4)Spring 和 ORM 等框架





![image-20210202012425688](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210202012425688.png)

## 5)MySQL 数据库和 SQL

数据库有关系型数据库和非关系型数据库，MySQL就是关系型数据库里的典型代表。

mysql的设计范式：每列都是原子的，每行都有主键，没有列与主键不相关。

注意mysql5.6和5.7、5.7和8.0版本之间的区别。

mysql有多个存储引擎，MyISAM和InnoDB

InnoDB支持行锁，支持事务，用的比较多。

MyISAM只支持表锁，不支持事务。

InnoDB索引用的B+数，因为它只有叶子节点才存储数据，这样可以多存索引。

InnoDB有undo log和redo log，用来保证数据的一致性。

隔离级别有4种：读未提交: READ UNCOMMITTED、读已提交: READ COMMITTED、可重复读: REPEATABLE READ、可串行化: SERIALIZABLE。

通过mvcc来实现 读已提交: READ COMMITTED、可重复读: REPEATABLE READ。

乐观锁与悲观锁。

单机mysql性能有限，后面发展出来主从复制、读写分离、MHA、MGR、MySQL Cluster。



![image-20210202215300905](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210202215300905.png)

## 6) 分库分表

随着数据越来越多，单表逐渐满足不了需求，出现了主从、读写分离等技术。但是这些也不能解决单库写的问题和容量问题，这个时候就发展出了分库分表。

分库分表分为垂直拆分和水平拆分，垂直拆分是按业务来拆，正好可以作为微服务改造的基础，不过垂直拆分分到一定程度就不能再拆分了；水平拆分，如果按时间来分的话，可以无限往后拆，解决了容量问题，但是数据迁移比较复杂，管理也很复杂。

数据库拆分之后，数据也可以分类为热数据、温数据、冷数据、冰数据，用不同的策略去处理。

数据库拆分之后，引发了一个问题，就是如何保证数据的一致性，这个时候就轮到分布式事务登场了。

分布式事务由两种，一种是强一致性的，比如XA，对性能影响比较大；另一种是弱一致性，可以不用事务，业务侧补偿冲正，也可以用柔性事务，保证最终一致性，性能损耗小，但是会有一段时间数据不一致。

柔性事务：TCC、SAGA、AT。



![image-20210202230557881](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210202230557881.png)



## 7)RPC 和微服务

RPC 是远程过程调用，简单的说，就是“像调用本地方法一样调用远程方法”。

RPC的关键是代理是用动态代理还是字节码，序列化协议用哪一种，网络传输是走http还是https。

Dubbo是比较出名的RPC框架，SPI设计，扩展性强。

最开始，服务都是单体服务，随着业务的发展，功能、数据越来越多，性能越来越慢，提高机器配置也是有限制的，改一个小地方可能会影响整个项目。在这样的背景下，先是出现代码分层，比如MVC，让代码逻辑更清晰。然后出现了SOA架构，ESB相当于加了一个中间层。

慢慢又演变出了微服务架构，服务架构又需要注册中心、配置中心、限流、熔断、网关等需求，SpringCloud有一整套解决方案。





![image-20210203004413053](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210203004413053.png)

## 8) 分布式缓存

缓存的**本质是空间换时间。**

热数据、读写比大的数据适合用缓存。

缓存设计需要考虑**容量**和**过期策略**。

缓存的发展：本地缓存 -》远程缓存

现在比较流行的缓存，本地缓存（guava），远程缓存（redis）。

redis到底是单线程还是多线程：内存处理线程一直是单线程，IO线程 redis6之前是单线程，redis6之后的多线程（NIO模型）。

redis的数据结构：字符串、散列、列表、集合、有序集合和三种高级数据结构（bitmaps、hyperloglogs、geo）。

redis的java客户端：Jedis、Lettuce、Redission。

redis使用经验：监控系统读写比和缓存命中率，做好容量评估，尽量每个业务使用独立的redis，规范key的使用。

redis高可用：主从模式、哨兵模式、集群模式。

以后的发展趋势：内存网格Hazelcast



![image-20210131144259207](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210131144259207.png)



## 9) 分布式消息队列

随着业务的发展，高峰时期请求量可能是日常请求量的几十倍上百倍。为了应对这种情况，发展处了消息队列，最开始是单机模式，数据存在内存。但是后面发现和数据库一样单机性能有限，数据存在内存重启服务就没了。所以后面出现了分布式消息队列，比如kafaka，它天生就支持分布式，也支持数据持久化。后面又演化出了第3代MQ，Pulsar，它把计算和存储分离来提高性能。

消息有3种确认机制，至少一次，至多一次，精确一次。我们可以根据不用的业务场景来选择，为了保证数据的一致性，需要自己保证消费幂等。



![image-20210203211735187](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210203211735187.png)



## 总结

课程从基础的JVM开始，一点一点的深入。由于BIO比较浪费CPU性能，而发展出了NIO。单线程性能不够，所以出现了并发编程，JUC包提供了很多工具来让线程协作，每次创建线程消耗太大，又引入了池化思想，出现了线程池。

单体服务越来越臃肿，单纯加机器配置已经到上限了，就出现了服务集群，后面发现瓶颈在单机数据库，又发展出数据库主从复制、读写分离、MHA、MGR。再后面多个系统集成，出现了SOA。由SOA又演化出了微服务，服务需要做拆分，服务拆分之后，数据库也需要做分库分表，分库分表之后又需要分布式事务。

有了分布式服务之后，就出现了分布式缓存、分布式消息队列来提升性能，保证稳定性。