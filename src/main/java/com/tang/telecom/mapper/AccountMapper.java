package com.tang.telecom.mapper;

import com.tang.telecom.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weepppp 2022/7/6 22:25
 **/
public interface AccountMapper {
    List<Account> getAccount();

    Account getAccountById(@Param("aid")String aid);

    int insertAccount(Account account);

    int updateAccount(Account account);

    int deleteAccount(@Param("aid")String aid);

    List<Account> getAccountByUid(@Param("uid")Integer uid);

}
