
package com.bruce.dubbo.account.rmb.service;


import com.bruce.dubbo.common.bo.AccountBO;

/**
 * The interface Payment service.
 *
 * @author bruce
 */
public interface PaymentService {
    
    /**
     * 订单支付
     *
     * @param bo AccountBO
     */
    void makePayment(AccountBO bo);
    
    /**
     * Test make payment.
     *
     * @param bo the AccountBO
     */
    void testMakePayment(AccountBO bo);

}
