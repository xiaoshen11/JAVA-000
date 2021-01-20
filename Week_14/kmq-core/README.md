## 说明

第一个版本，完全基于内存queue的消息队列，实现了最基础的三个功能：

- 创建topic
- 订阅topic和poll消息
- 发送消息到topic

具体参见demo.KmqDemo

第二个版本：自定义Queue 2、去掉内存Queue，设计自定义Queue，实现消息确认和消费offset 
- 自定义内存Message数组模拟Queue。 
- 使用指针记录当前消息写入位置。 
- 对于每个命名消费者，用指针记录消费位置。

第三个版本：基于SpringMVC实现MQServer 3、拆分broker和client(包括producer和consumer) 
- 将Queue保存到web server端 
- 设计消息读写API接口，确认接口，提交offset接口 
- producer和consumer通过httpclient访问Queue 
- 实现消息确认，offset提交 
- 实现consumer从offset增量拉取