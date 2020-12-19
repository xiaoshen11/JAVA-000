
package com.bruce.dubbo.common.dollar.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The type DollarAccount dto.
 *
 * @author bruce
 */
@Data
public class DollarAccountDTO implements Serializable {

    private static final long serialVersionUID = 7223470850578998426L;
    
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 扣款金额
     */
    private BigDecimal amount;

}
