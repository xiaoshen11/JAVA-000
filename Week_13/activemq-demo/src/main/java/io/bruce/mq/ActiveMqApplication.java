package io.bruce.mq;


import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.jms.*;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class ActiveMqApplication {

    public static void main(String[] args) {

//        Destination destination = new ActiveMQTopic("test.topic");
//        testDestination(destination);
        SpringApplication.run(ActiveMqApplication.class, args);
    }

//    public static void testDestination(Destination destination){
//
//        try {
//            //创建连接和会话
//            ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
//            ActiveMQConnection conn = (ActiveMQConnection)factory.createConnection();
//            conn.start();
//            Session session = conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
//
//            //创建消费者
//            MessageConsumer consumer = session.createConsumer(destination);
//            final AtomicInteger count = new AtomicInteger(0);
//            MessageListener listener = new MessageListener() {
//                @Override
//                public void onMessage(Message message) {
//                    System.out.println(count.incrementAndGet() + " => receive from " + destination.toString() + ":" + message);
//                }
//            };
//            //绑定监听器
//            consumer.setMessageListener(listener);
//
//            //创建生产者
//            MessageProducer producer = session.createProducer(destination);
//            int index = 0;
//            while (index++ < 100) {
//                TextMessage message = session.createTextMessage(index + " message.");
//                producer.send(message);
//            }
//
//            Thread.sleep(2000);
//            session.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

}
