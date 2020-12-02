package com.bruce.mysql.model;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * goods
 * @author 
 */
@Data
public class Goods implements Serializable {
    private Long id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 大小
     */
    private String size;

    /**
     * 颜色
     */
    private String color;

    /**
     * 单位
     */
    private String unit;

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