package io.kimmking.kmq.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * kmq
 * @author 
 */
@Data
public class Kmq implements Serializable {
    private Long id;

    /**
     * 队列名称
     */
    private String topic;

    /**
     * 队列容量
     */
    private Integer capacity;

    /**
     * 前已确认接收到的消息的数量
     */
    private Integer size;

    private static final long serialVersionUID = 1L;
}