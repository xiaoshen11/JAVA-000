package io.kimmking.kmq.core;

public class KmqConsumer<T> {

    private final KmqBroker broker;

    private Kmq kmq;

    /**
     * 记录当前已消费的消息的 offset
     */
    private int offset;

    public KmqConsumer(KmqBroker broker) {
        this.broker = broker;
    }

    public int getOffset() {
        return offset;
    }

    public void subscribe(String topic) {
        this.kmq = this.broker.findKmq(topic);
        if (null == kmq) throw new RuntimeException("Topic[" + topic + "] doesn't exist.");
    }

    public KmqMessage<T> poll(long timeout) {
        KmqMessage message = kmq.poll(offset);
        if(message == null){
            return null;
        }
        offset++;
        return message;
    }

}
