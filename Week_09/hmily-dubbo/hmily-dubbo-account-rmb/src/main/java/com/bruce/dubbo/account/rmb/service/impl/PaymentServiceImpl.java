
package com.bruce.dubbo.account.rmb.service.impl;


import com.bruce.dubbo.account.rmb.service.PaymentService;
import com.bruce.dubbo.common.bo.AccountBO;
import com.bruce.dubbo.common.dollar.api.DollarAccountService;
import com.bruce.dubbo.common.rmb.dto.RMBAccountDTO;
import com.bruce.dubbo.common.rmb.mapper.RMBAccountMapper;
import org.dromara.hmily.annotation.HmilyTCC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bruce
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final RMBAccountMapper rmbAccountMapper;

    private final DollarAccountService dollarAccountService;

    @Autowired(required = false)
    public PaymentServiceImpl(RMBAccountMapper rmbAccountMapper,
                              DollarAccountService dollarAccountService) {
        this.rmbAccountMapper = rmbAccountMapper;
        this.dollarAccountService = dollarAccountService;
    }
    
    @Override
    @HmilyTCC(confirmMethod = "confirmOrderStatus", cancelMethod = "cancelOrderStatus")
    public void makePayment(AccountBO bo) {
        //冻结人民币用户余额
        rmbAccountMapper.update(buildRMBAccountDTO(bo));

        //冻结美元用户余额
        dollarAccountService.payment(bo);
    }
    
    @Override
    public void testMakePayment(AccountBO bo) {
        //冻结人民币用户余额
        rmbAccountMapper.update(buildRMBAccountDTO(bo));

        //冻结美元用户余额
        dollarAccountService.payment(bo);
    }

    @Transactional
    public void confirmOrderStatus(AccountBO bo) {
        rmbAccountMapper.confirm(buildRMBAccountDTO(bo));
        rmbAccountMapper.confirm2(buildRMBAccountDTO2(bo));
        LOGGER.info("=========进行订单confirm操作完成================");
    }

    @Transactional
    public void cancelOrderStatus(AccountBO bo) {
        rmbAccountMapper.cancel(buildRMBAccountDTO(bo));
        rmbAccountMapper.cancel2(buildRMBAccountDTO2(bo));
        LOGGER.info("=========进行订单cancel操作完成================");
    }

    private RMBAccountDTO buildRMBAccountDTO(AccountBO bo) {
        RMBAccountDTO accountDTO = new RMBAccountDTO();
        accountDTO.setAmount(bo.getRmbAmount());
        accountDTO.setUserId(bo.getRmbUserId());
        return accountDTO;
    }
    private RMBAccountDTO buildRMBAccountDTO2(AccountBO bo) {
        RMBAccountDTO accountDTO = new RMBAccountDTO();
        accountDTO.setAmount(bo.getRmbAmount());
        accountDTO.setUserId(bo.getDollarUserId());
        return accountDTO;
    }

}
