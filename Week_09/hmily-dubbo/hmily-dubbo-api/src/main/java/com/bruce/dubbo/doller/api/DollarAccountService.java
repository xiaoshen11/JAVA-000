
package com.bruce.dubbo.doller.api;


import com.bruce.dubbo.doller.dto.DollarAccountDTO;
import com.bruce.dubbo.rmb.entity.RMBAccountDO;
import org.dromara.hmily.annotation.Hmily;

/**
 * The interface DollarAccount service.
 *
 * @author bruce
 */
public interface DollarAccountService {
    
    /**
     * 扣款支付
     *
     * @param DollarAccountDTO 参数dto
     */
    @Hmily
    boolean payment(DollarAccountDTO DollarAccountDTO);
    
    /**
     * Mock try payment exception.
     *
     * @param DollarAccountDTO the account dto
     */
    @Hmily
    boolean mockTryPaymentException(DollarAccountDTO DollarAccountDTO);
    
    /**
     * Mock try payment timeout.
     *
     * @param DollarAccountDTO the account dto
     */
    @Hmily
    boolean mockTryPaymentTimeout(DollarAccountDTO DollarAccountDTO);
    
    /**
     * Payment tac boolean.
     *
     * @param DollarAccountDTO the account dto
     * @return the boolean
     */
    @Hmily
    boolean paymentTAC(DollarAccountDTO DollarAccountDTO);
    
    /**
     * Test payment boolean.
     *
     * @param DollarAccountDTO the account dto
     * @return the boolean
     */
    boolean testPayment(DollarAccountDTO DollarAccountDTO);
    
    /**
     * 获取用户账户信息
     *
     * @param userId 用户id
     * @return AccountDO account do
     */
    RMBAccountDO findByUserId(Integer userId);
}
