package com.tang.telecom.service;

import com.tang.telecom.entity.Account;
import com.tang.telecom.entity.Customer;
import com.tang.telecom.mapper.AccountMapper;
import com.tang.telecom.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author weepppp 2022/7/6 22:47
 **/
@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    CustomerMapper customerMapper;

    public List<Account> getAccount(){
        return accountMapper.getAccount();
    }

    public Boolean insertAccount(Account account){
        // 自动生成Ayyyymmddhhmiss格式的aid
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        String format = simpleDateFormat.format(new Date());
        String aid = "A" + format;
        account.setAid(aid);
        // 验证添加记录的uid是否是已经存在的客户id，如果不存在，则添加失败
        // 此处验证也可以 1.在前端提交数据前就单独查询返回，如果不存在，直接提示“此客户id不存在” 2.前端直接通过下拉框限定可选的客户
        Customer customerById = customerMapper.getCustomerById(account.getUid());
        if (customerById == null){
            return false;
        }
        return accountMapper.insertAccount(account)==1;
    }

    public Boolean updateAccount(Account account){
        // 更新也同样进行uid存在性的校验
        Customer customerById = customerMapper.getCustomerById(account.getUid());
        if (customerById == null){
            return false;
        }
        // 可以依据前端传来的客户的不同相关信息，进行相对应的表关联查找更新。此处就按照前端直接传递了客户id进行更新处理
        // 消费金额、余额等字段可以不进行更新，直接查询原有记录并赋值即可，或者重新new实体只对要更新的字段进行处理。此处就按全部字段都进行更新去处理。
        return accountMapper.updateAccount(account)==1;
    }

    public Boolean deleteAccount(String aid) {
        if (accountMapper.getAccountById(aid) == null){
            return false;
        }
        // TODO 根据id查询电话表是否有记录，如果有记录就不能删除该条用户记录
        if (accountMapper.deleteAccount(aid)==1){
            return true;
        }
        return false;
    }
}
