# **周四作业**

```java
package java0.conc0303;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
 * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
 * 写出你的方法，越多越好，提交到github。
 *
 * 一个简单的代码参考：
 */
public class Homework03 {
    
    public static void main(String[] args) {
        
        long start=System.currentTimeMillis();
        //方法一
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> result = executor.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                return sum();
            }
        });
        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        
//        int result = sum(); //这是得到的返回值
        executor.shutdown();
        // 确保  拿到result 并输出
        try {
            System.out.println("异步计算结果为："+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
        
        // 然后退出main线程

        //方法二
        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        });
        new Thread(task).start();
        try {
            System.out.println("result: " + task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
    
    private static int sum() {
        return fibo(36);
    }
    
    private static int fibo(int a) {
        if ( a < 2) 
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}

```



# **周六作业**
1.列举常用的并发操作 API 和工具类，简单分析其使用场景和优缺点。


2.请思考：什么是并发？什么是高并发？实现高并发高可用系统需要考虑哪些因素，对于这些你是怎么理解的？
 ```
  并发：同一时间，有多个相同的请求过来，就是并发
  高并发：就是同一时间，过来的请求非常多
  实现高并发高可用系统：需要考虑安全、限流、熔断、自动扩容、用队列削峰、流量监控、异常告警
  
```
  
  
3.请思考：还有哪些跟并发类似 / 有关的场景和问题，有哪些可以借鉴的解决办法。
```
比如说挤公交车，大家都想上车，但是车的容量是有限的，解决办法可以是：增大车厢的容量（加内存），或者调多台公交车（扩容，类似微服务部署多份）
```

4.把多线程和并发相关知识带你梳理一遍，画一个脑图，截图上传到 Github 上。
  可选工具：xmind，百度脑图，wps，MindManage 或其他。
![1604850413(1)](1604850413(1).png)

