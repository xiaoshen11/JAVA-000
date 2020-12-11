package com.bruce.mysql.model;

import lombok.Data;

import java.io.Serializable;

/**
 * order
 * @author
 */
@Data
public class Order implements Serializable {

    private Long orderId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 订单金额
     */
    private Double totalAmount;

    /**
     * 优惠金额
     */
    private Double discountAmount;

    /**
     * 实付金额
     */
    private Double actualAmount;

    /**
     * 订单状态 0待支付 1支付成功 2取消订单 3退款
     */
    private Integer orderStatus;

    /**
     * 创建时间（毫秒数）
     */
    private Long createDate;

    /**
     * 更新时间（毫秒数）
     */
    private Long updateDate;

    /**
     * 创建人id
     */
    private Long createBy;

    /**
     * 更新人id
     */
    private Long updateBy;

    /**
     * 删除标识 0未删除 1已删除
     */
    private Boolean delFlag;

    private static final long serialVersionUID = 1L;
}