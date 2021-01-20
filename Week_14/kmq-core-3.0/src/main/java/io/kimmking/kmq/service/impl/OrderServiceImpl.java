package io.kimmking.kmq.service.impl;

import io.kimmking.kmq.entity.Consumer;
import io.kimmking.kmq.entity.Kmq;
import io.kimmking.kmq.entity.Order;
import io.kimmking.kmq.mapper.ConsumerDao;
import io.kimmking.kmq.mapper.KmqDao;
import io.kimmking.kmq.mapper.OrderDao;
import io.kimmking.kmq.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private KmqDao kmqDao;

    @Autowired
    private ConsumerDao consumerDao;

    @Transactional
    @Override
    public void consumerOrder(Consumer consumer, String topic) {
        int offset = 0;
        if(consumer != null && consumer.getId() != null){
            offset = consumer.getOffset();
            consumer.setOffset(consumer.getOffset() + 1);
            consumerDao.updateByPrimaryKeySelective(consumer);

        }else{
            consumer = new Consumer();
            consumer.setOffset(1);
            consumer.setTopic(topic);
            consumerDao.insert(consumer);
            offset = 1;
        }

        Order order = orderDao.getOrder(topic,offset);
        System.out.println("offset=" + consumer.getOffset() + ", " + order.toString());
    }

    @Transactional
    @Override
    public void producerOrder(String topic,Order order) {
        Kmq kmq = kmqDao.selectByTopic(topic);
        if(kmq != null){
            if(kmq.getSize() >= kmq.getCapacity()){
                throw new RuntimeException("Topic[" + topic + "] capacity is full.");
            }
            kmq.setSize(kmq.getSize() + 1);
            kmqDao.updateByPrimaryKeySelective(kmq);
        }else{
            kmq = new Kmq();
            kmq.setCapacity(10);
            kmq.setSize(1);
            kmq.setTopic(topic);
            kmqDao.insert(kmq);
        }
        order.setTopic(topic);
        orderDao.insert(order);
    }

}
