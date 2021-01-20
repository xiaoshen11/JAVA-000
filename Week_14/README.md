# 作业

### 2、（必做）思考和设计自定义 MQ 第二个版本或第三个版本，写代码实现其中至少一个功能点，把设计思路和实现代码，提交到 GitHub。

第二个版本实现了

```
- 自定义内存Message数组模拟Queue。 
- 使用指针记录当前消息写入位置。
```

https://github.com/xiaoshen11/JAVA-000/tree/main/Week_14/kmq-core



第三个版本实现了

```
- 将Queue保存到web server端 
- 设计消息读写API接口，确认接口，提交offset接口 
- producer和consumer通过httpclient访问Queue 
- 实现消息确认，offset提交 
- 实现consumer从offset增量拉取
```

https://github.com/xiaoshen11/JAVA-000/tree/main/Week_14/kmq-core-3.0

生产消息

![image-20210121003121035](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210121003121035.png)

消费消息

![image-20210121003131716](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210121003131716.png)

![image-20210121003145358](C:\Users\34741\AppData\Roaming\Typora\typora-user-images\image-20210121003145358.png)