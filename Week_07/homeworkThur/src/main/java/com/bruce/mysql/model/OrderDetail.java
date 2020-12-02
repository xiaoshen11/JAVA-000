package com.bruce.mysql.model;

import java.io.Serializable;
import lombok.Data;

/**
 * order_detail
 * @author 
 */
@Data
public class OrderDetail implements Serializable {
    private Long id;

    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品数量
     */
    private Integer goodsNum;

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