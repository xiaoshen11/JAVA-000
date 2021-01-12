# 作业

### 1、（必做）搭建ActiveMQ服务，基于JMS，写代码分别实现对于queue和topic的消息 生产和消费，代码提交到github。

生产：

```
	@PostMapping("/queue/test")
    public String sendQueue(@RequestBody String str) {
        this.sendMessage(this.queue, str);
        return "success";
    }

    @PostMapping("/topic/test")
    public String sendTopic(@RequestBody String str) {
        this.sendMessage(this.topic, str);
        return "success";
    }

    // 发送消息，destination是发送到的队列，message是待发送的消息
    private void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }	
```



消费：

```
 @JmsListener(destination = "${spring.activemq.queue-name}",containerFactory = "queueListener")
    public void readActiveQueue(String message) {
        System.out.println("queue接受到：" + message);
    }
    
  @JmsListener(destination = "${spring.activemq.topic-name}",containerFactory = "topicListener")
    public void readActiveQueue(String message) {
        System.out.println("topic接受到：" + message);
    }  
```



### 2、（选做）基于数据库的订单表，模拟消息队列处理订单： 

1）一个程序往表里写新订单，标记状态为未处理(status=0); 

2）另一个程序每隔100ms定时从表里读取所有status=0的订单，打印一下订单数据， 

然后改成完成status=1；

3）（挑战☆）考虑失败重试策略，考虑多个消费程序如何协作。

```
@Scheduled(cron = "1/1 * * * * ?")
    public void handleOrder() {
        List<Order> list = orderMapper.getUnHandleOrder();
        if(!CollectionUtils.isEmpty(list)){
            for (Order order : list) {
                order.setStatus(1);
                orderMapper.updateOrderStatus(order);
                System.out.println("handle order, order-id: " + order.getId());
            }
        }else{
            System.out.println("no data to handle");
        }
    }
```

 

### 3、（选做）将上述订单处理场景，改成使用ActiveMQ发送消息处理模式。

```
@JmsListener(destination = Order.ORDER_TOPIC,containerFactory = "topicListener")
    public void readActiveQueue(String message) {
        System.out.println("topic接受到：" + message);
        Order order = JSON.parseObject(message,Order.class);
        order.setStatus(1);
        orderMapper.updateOrderStatus(order);
        System.out.println("handle order, order-id: " + order.getId());

    }
```

https://github.com/xiaoshen11/JAVA-000/tree/main/Week_13/activema-demo



**周六作业：**
**1.（必做）**搭建一个 3 节点 Kafka 集群，测试功能和性能；实现 spring kafka 下对 kafka 集群的操作，将代码提交到 github。

```
@Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    // 发送消息
    @GetMapping("/kafka/normal/{message}")
    public void sendMessage1(@PathVariable("message") String normalMessage) {
        kafkaTemplate.send("testk", normalMessage);
    }


@KafkaListener(topics = {"testk"})
    public void onMessage1(ConsumerRecord<?, ?> record){
        // 消费的哪个topic、partition的消息,打印出消息内容
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
    }
```

https://github.com/xiaoshen11/JAVA-000/tree/main/Week_13/spring-kafka-demo