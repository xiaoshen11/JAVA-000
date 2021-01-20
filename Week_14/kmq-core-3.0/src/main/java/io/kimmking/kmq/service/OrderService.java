package io.kimmking.kmq.service;

import io.kimmking.kmq.entity.Consumer;
import io.kimmking.kmq.entity.Order;

public interface OrderService {

    void consumerOrder(Consumer consumer, String topic);

    void producerOrder(String topic, Order order);

}
