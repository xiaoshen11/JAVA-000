package com.bruce.mysql.model;

import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {
    private Long id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 0未知 1男 2女
     */
    private Integer sex;

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