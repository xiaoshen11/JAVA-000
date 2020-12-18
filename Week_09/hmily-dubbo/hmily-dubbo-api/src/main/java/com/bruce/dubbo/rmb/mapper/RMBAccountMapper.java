
package com.bruce.dubbo.rmb.mapper;


import com.bruce.dubbo.rmb.dto.RMBAccountDTO;
import com.bruce.dubbo.rmb.entity.RMBAccountDO;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * The interface Account mapper.
 *
 * @author bruce
 */
public interface RMBAccountMapper {
    
    /**
     * Update int.
     *
     * @param RMBAccountDTO the account dto
     * @return the int
     */
    @Update("update t_rmb_account set balance = balance - #{amount}," +
            " freeze_amount= freeze_amount + #{amount} ,update_time = now()" +
            " where user_id =#{userId}  and  balance > 0  ")
    int update(RMBAccountDTO RMBAccountDTO);
    
    /**
     * Update tac int.
     *
     * @param RMBAccountDTO the account dto
     * @return the int
     */
    @Update("update t_rmb_account set balance = balance - #{amount}, update_time = now()" +
            " where user_id =#{userId} and balance > 0  ")
    int updateTAC(RMBAccountDTO RMBAccountDTO);
    
    /**
     * Test update int.
     *
     * @param RMBAccountDTO the account dto
     * @return the int
     */
    @Update("update t_rmb_account set balance = balance - #{amount}, update_time = now() " +
            " where user_id =#{userId}  and  balance > 0  ")
    int testUpdate(RMBAccountDTO RMBAccountDTO);
    
    /**
     * Confirm int.
     *
     * @param RMBAccountDTO the account dto
     * @return the int
     */
    @Update("update t_rmb_account set " +
            " freeze_amount= freeze_amount - #{amount}" +
            " where user_id =#{userId}  and freeze_amount >0 ")
    int confirm(RMBAccountDTO RMBAccountDTO);
    
    /**
     * Cancel int.
     *
     * @param RMBAccountDTO the account dto
     * @return the int
     */
    @Update("update t_rmb_account set balance = balance + #{amount}," +
            " freeze_amount= freeze_amount -  #{amount} " +
            " where user_id =#{userId}  and freeze_amount >0")
    int cancel(RMBAccountDTO RMBAccountDTO);
    
    /**
     * 根据userId获取用户账户信息
     *
     * @param userId 用户id
     * @return RMBAccountDTO account do
     */
    @Select("select id,user_id,balance, freeze_amount from t_rmb_account where user_id =#{userId} limit 1")
    RMBAccountDO findByUserId(Integer userId);
}
