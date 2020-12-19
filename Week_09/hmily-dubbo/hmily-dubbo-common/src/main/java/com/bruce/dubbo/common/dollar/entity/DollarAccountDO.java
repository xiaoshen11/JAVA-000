
package com.bruce.dubbo.common.dollar.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The type DollarAccount do.
 *
 * @author bruce
 */
@Data
public class DollarAccountDO implements Serializable {

    private static final long serialVersionUID = -81849676368907418L;

    private Integer id;

    private Integer userId;

    private BigDecimal balance;

    private BigDecimal freezeAmount;

    private Date createTime;

    private Date updateTime;
}
