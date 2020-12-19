
package com.bruce.dubbo.account.dollar.service;

import com.bruce.dubbo.common.bo.AccountBO;
import com.bruce.dubbo.common.dollar.api.DollarAccountService;
import com.bruce.dubbo.common.dollar.dto.DollarAccountDTO;
import com.bruce.dubbo.common.dollar.entity.DollarAccountDO;
import com.bruce.dubbo.common.dollar.mapper.DollarAccountMapper;
import org.dromara.hmily.annotation.HmilyTCC;
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
@Service("dollarAccountService")
public class DollarAccountAServiceImpl implements DollarAccountService {

    /**
     * logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DollarAccountAServiceImpl.class);

    /**
     * The Trycount.
     */
    private static AtomicInteger trycount = new AtomicInteger(0);

    /**
     * The Confrim count.
     */
    private static AtomicInteger confrimCount = new AtomicInteger(0);

    private final DollarAccountMapper dollarAccountMapper;

    /**
     * Instantiates a new Account service.
     *
     * @param rmbAccountMapper the account mapper
     */
    @Autowired(required = false)
    public DollarAccountAServiceImpl(final DollarAccountMapper dollarAccountMapper) {
        this.dollarAccountMapper = dollarAccountMapper;

    }

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean payment(AccountBO bo) {

        return dollarAccountMapper.update(buildDollarAccountDTO(bo)) > 0;
    }

    @Override
    public DollarAccountDO findByUserId(Integer userId) {
        return dollarAccountMapper.findByUserId(userId);
    }

    /**
     * Confirm boolean.
     *
     * @param RMBAccountDTO the account dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean confirm(AccountBO bo) {
        LOGGER.info("============dubbo tcc 执行确认付款接口===============");
        dollarAccountMapper.confirm(buildDollarAccountDTO(bo));
        dollarAccountMapper.confirm2(buildDollarAccountDTO2(bo));
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
    public boolean cancel(AccountBO bo) {
        LOGGER.info("============ dubbo tcc 执行取消付款接口===============");

        dollarAccountMapper.cancel(buildDollarAccountDTO(bo));
        dollarAccountMapper.cancel2(buildDollarAccountDTO2(bo));
        return Boolean.TRUE;
    }

    private DollarAccountDTO buildDollarAccountDTO(AccountBO bo) {
        DollarAccountDTO accountDTO = new DollarAccountDTO();
        accountDTO.setAmount(bo.getDollarAmount());
        accountDTO.setUserId(bo.getDollarUserId());
        return accountDTO;
    }

    DollarAccountDTO buildDollarAccountDTO2(AccountBO bo) {
        DollarAccountDTO accountDTO = new DollarAccountDTO();
        accountDTO.setAmount(bo.getDollarAmount());
        accountDTO.setUserId(bo.getRmbUserId());
        return accountDTO;
    }
}
