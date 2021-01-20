package io.kimmking.kmq.core;

import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class Kmq {

    public Kmq(String topic, int capacity) {
        this.topic = topic;
        this.capacity = capacity;
        this.queue = new KmqMessage[capacity];
    }

    private String topic;

    private int capacity;

    /**
     * 当前已确认接收到的消息的数量
     */
    private int size;

//    private LinkedBlockingQueue<KmqMessage> queue;

    private KmqMessage[] queue;

    public boolean send(KmqMessage message) {
        if(size >= capacity){
            throw new RuntimeException("Topic[" + topic + "] capacity is full.");
        }
        queue[size] = message;
        size ++;
        return true;
    }

    public KmqMessage poll(int offset) {
        if(offset > size){
            System.out.println("Topic[" + topic + "] offset over queue size.");
            return null;
        }
        return queue[offset];
    }

//    @SneakyThrows
//    public KmqMessage poll(long timeout) {
//        TimeUnit.MILLISECONDS.sleep(timeout);
//        return queue[size];
//    }

}
