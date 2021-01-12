package io.bruce.mq.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Order implements Serializable {


    public static final String ORDER_TOPIC = "order-topic";

    private Integer id;

    private String name;

    /**
     * 订单状态 0未处理 1已处理
     */
    private Integer status;

}
