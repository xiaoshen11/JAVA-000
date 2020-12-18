
package com.bruce.dubbo.rmb.api;


import com.bruce.dubbo.rmb.dto.RMBAccountDTO;
import com.bruce.dubbo.rmb.entity.RMBAccountDO;
import org.dromara.hmily.annotation.Hmily;

/**
 * The interface RMBAccount service.
 *
 * @author bruce
 */
public interface RMBAccountService {
    
    /**
     * 扣款支付
     *
     * @param RMBAccountDTO 参数dto
     */
    @Hmily
    boolean payment(RMBAccountDTO RMBAccountDTO);
    
    /**
     * Mock try payment exception.
     *
     * @param RMBAccountDTO the account dto
     */
    @Hmily
    boolean mockTryPaymentException(RMBAccountDTO RMBAccountDTO);
    
    /**
     * Mock try payment timeout.
     *
     * @param RMBAccountDTO the account dto
     */
    @Hmily
    boolean mockTryPaymentTimeout(RMBAccountDTO RMBAccountDTO);
    
    /**
     * Payment tac boolean.
     *
     * @param RMBAccountDTO the account dto
     * @return the boolean
     */
    @Hmily
    boolean paymentTAC(RMBAccountDTO RMBAccountDTO);
    
    /**
     * Test payment boolean.
     *
     * @param RMBAccountDTO the account dto
     * @return the boolean
     */
    boolean testPayment(RMBAccountDTO RMBAccountDTO);
    
    /**
     * 获取用户账户信息
     *
     * @param userId 用户id
     * @return AccountDO account do
     */
    RMBAccountDO findByUserId(Integer userId);
}
