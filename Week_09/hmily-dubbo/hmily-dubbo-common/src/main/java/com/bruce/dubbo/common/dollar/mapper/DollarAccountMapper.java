
package com.bruce.dubbo.common.dollar.mapper;


import com.bruce.dubbo.common.dollar.dto.DollarAccountDTO;
import com.bruce.dubbo.common.dollar.entity.DollarAccountDO;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * The interface Account mapper.
 *
 * @author bruce
 */
public interface DollarAccountMapper {
    
    /**
     * Update int.
     *
     * @param DollarAccountDTO the account dto
     * @return the int
     */
    @Update("update t_dollar_account set balance = balance - #{amount}," +
            " freeze_amount= freeze_amount + #{amount} ,update_time = now()" +
            " where user_id =#{userId}  and  balance > 0  ")
    int update(DollarAccountDTO DollarAccountDTO);
    
    /**
     * Update tac int.
     *
     * @param DollarAccountDTO the account dto
     * @return the int
     */
    @Update("update t_dollar_account set balance = balance - #{amount}, update_time = now()" +
            " where user_id =#{userId} and balance > 0  ")
    int updateTAC(DollarAccountDTO DollarAccountDTO);
    
    /**
     * Test update int.
     *
     * @param DollarAccountDTO the account dto
     * @return the int
     */
    @Update("update t_dollar_account set balance = balance - #{amount}, update_time = now() " +
            " where user_id =#{userId}  and  balance > 0  ")
    int testUpdate(DollarAccountDTO DollarAccountDTO);
    
    /**
     * Confirm int.
     *
     * @param DollarAccountDTO the account dto
     * @return the int
     */
    @Update("update t_dollar_account set " +
            " freeze_amount= freeze_amount - #{amount}" +
            " where user_id =#{userId}  and freeze_amount >0 ")
    int confirm(DollarAccountDTO DollarAccountDTO);

    @Update("update t_dollar_account set " +
            "  balance = balance + #{amount}" +
            " where user_id =#{userId}  ")
    int confirm2(DollarAccountDTO DollarAccountDTO);
    
    /**
     * Cancel int.
     *
     * @param DollarAccountDTO the account dto
     * @return the int
     */
    @Update("update t_dollar_account set balance = balance + #{amount}," +
            " freeze_amount= freeze_amount -  #{amount} " +
            " where user_id =#{userId}  and freeze_amount >0")
    int cancel(DollarAccountDTO DollarAccountDTO);

    @Update("update t_dollar_account set " +
            "  balance = balance - #{amount}" +
            " where user_id =#{userId}  ")
    int cancel2(DollarAccountDTO DollarAccountDTO);
    
    /**
     * 根据userId获取用户账户信息
     *
     * @param userId 用户id
     * @return DollarAccountDTO account do
     */
    @Select("select id,user_id,balance, freeze_amount from t_dollar_account where user_id =#{userId} limit 1")
    DollarAccountDO findByUserId(Integer userId);
}
