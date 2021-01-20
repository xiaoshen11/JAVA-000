package io.kimmking.kmq.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

/**
 * order
 * @author 
 */
@Data
@ToString
public class Order implements Serializable {
    private Long id;

    private Long ts;

    private String symbol;

    private Double price;

    /**
     * 队列名称
     */
    private String topic;

    private static final long serialVersionUID = 1L;
}