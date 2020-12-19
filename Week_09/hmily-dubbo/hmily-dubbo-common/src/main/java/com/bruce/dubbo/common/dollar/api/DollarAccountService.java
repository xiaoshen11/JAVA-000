
package com.bruce.dubbo.common.dollar.api;


import com.bruce.dubbo.common.bo.AccountBO;
import com.bruce.dubbo.common.dollar.entity.DollarAccountDO;
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
    boolean payment(AccountBO bo);
    
    /**
     * 获取用户账户信息
     *
     * @param userId 用户id
     * @return AccountDO account do
     */
    DollarAccountDO findByUserId(Integer userId);
}
