
package com.bruce.dubbo.account.rmb.service.impl;

import com.bruce.dubbo.common.rmb.api.RMBAccountService;
import com.bruce.dubbo.common.rmb.dto.RMBAccountDTO;
import com.bruce.dubbo.common.rmb.entity.RMBAccountDO;
import com.bruce.dubbo.common.rmb.mapper.RMBAccountMapper;
import org.dromara.hmily.annotation.HmilyTAC;
import org.dromara.hmily.annotation.HmilyTCC;
import org.dromara.hmily.common.exception.HmilyRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * The type Account service.
 *
 * @author bruce
 */
@Service("accountService")
public class RMBAccountAServiceImpl implements RMBAccountService {

    /**
     * logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(RMBAccountAServiceImpl.class);

    /**
     * The Trycount.
     */
    private static AtomicInteger trycount = new AtomicInteger(0);

    /**
     * The Confrim count.
     */
    private static AtomicInteger confrimCount = new AtomicInteger(0);

    private final RMBAccountMapper rmbAccountMapper;

    /**
     * Instantiates a new Account service.
     *
     * @param rmbAccountMapper the account mapper
     */
    @Autowired(required = false)
    public RMBAccountAServiceImpl(final RMBAccountMapper rmbAccountMapper) {
        this.rmbAccountMapper = rmbAccountMapper;

    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean payment(RMBAccountDTO RMBAccountDTO) {
        return rmbAccountMapper.update(RMBAccountDTO) > 0;
    }
    
    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean mockTryPaymentException(RMBAccountDTO RMBAccountDTO) {
        throw new HmilyRuntimeException("账户扣减异常！");
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean mockTryPaymentTimeout(RMBAccountDTO RMBAccountDTO) {
        try {
            //模拟延迟 当前线程暂停10秒
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        final int decrease = rmbAccountMapper.update(RMBAccountDTO);
        if (decrease != 1) {
            throw new HmilyRuntimeException("库存不足");
        }
        return true;
    }
    
    @Override
    @HmilyTAC
    public boolean paymentTAC(RMBAccountDTO RMBAccountDTO) {
        return rmbAccountMapper.updateTAC(RMBAccountDTO) > 0;
    }
    
    @Override
    public boolean testPayment(RMBAccountDTO RMBAccountDTO) {
        rmbAccountMapper.testUpdate(RMBAccountDTO);
        return Boolean.TRUE;
    }
    
    @Override
    public RMBAccountDO findByUserId(Integer userId) {
        return rmbAccountMapper.findByUserId(userId);
    }

    /**
     * Confirm boolean.
     *
     * @param RMBAccountDTO the account dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean confirm(RMBAccountDTO RMBAccountDTO) {
        LOGGER.info("============dubbo tcc 执行确认付款接口===============");
        rmbAccountMapper.confirm(RMBAccountDTO);
        final int i = confrimCount.incrementAndGet();
        LOGGER.info("调用了account confirm " + i + " 次");
        return Boolean.TRUE;
    }
    
    /**
     * Cancel boolean.
     *
     * @param RMBAccountDTO the account dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(RMBAccountDTO RMBAccountDTO) {
        LOGGER.info("============ dubbo tcc 执行取消付款接口===============");
        final RMBAccountDO accountDO = rmbAccountMapper.findByUserId(RMBAccountDTO.getUserId());
        rmbAccountMapper.cancel(RMBAccountDTO);
        return Boolean.TRUE;
    }
}
