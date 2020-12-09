package com.bruce.mysql.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单
 * @author lw
 */
@Data
@NoArgsConstructor
public class Order {

    private Long order_id;
    private Long user_id;

    public Order(long userId, Long order_id) {
        this.order_id = order_id;
        this.user_id = userId;
    }
}
