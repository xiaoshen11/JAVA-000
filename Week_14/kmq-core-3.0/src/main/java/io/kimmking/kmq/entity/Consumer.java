package io.kimmking.kmq.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * consumer
 * @author 
 */
@Data
public class Consumer implements Serializable {
    private Long id;

    /**
     * 队列名称
     */
    private String topic;

    /**
     * 记录当前已消费的消息的 offset
     */
    private Integer offset;

    private static final long serialVersionUID = 1L;
}