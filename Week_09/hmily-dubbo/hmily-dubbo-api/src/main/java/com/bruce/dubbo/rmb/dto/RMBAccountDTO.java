
package com.bruce.dubbo.rmb.dto;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * The type RMBAccount dto.
 *
 * @author bruce
 */
@Data
public class RMBAccountDTO implements Serializable {

    private static final long serialVersionUID = 7223470850578998427L;
    
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 扣款金额
     */
    private BigDecimal amount;

}
