package com.bruce.dubbo.common.bo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AccountBO implements Serializable {

    private static final long serialVersionUID = 7223470850578998424L;
    /**
     * 人民币用户
     */
    private Integer rmbUserId;

    /**
     * 美元用户
     */
    private Integer dollarUserId;

    /**
     * 人民币扣款金额
     */
    private BigDecimal rmbAmount;

    /**
     * 美元扣款金额
     */
    private BigDecimal dollarAmount;


}
