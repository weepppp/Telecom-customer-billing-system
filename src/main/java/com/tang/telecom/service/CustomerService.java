package com.tang.telecom.service;

import com.tang.telecom.entity.Account;
import com.tang.telecom.entity.Customer;
import com.tang.telecom.mapper.AccountMapper;
import com.tang.telecom.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weepppp 2022/7/6 19:17
 **/
@Service
public class CustomerService {

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    AccountMapper accountMapper;

    public List<Customer> getCustomer(){
        return customerMapper.getCustomer();
    }

    public Boolean insertCustomer(Customer customer){
        return customerMapper.insertCustomer(customer)==1;
    }

    public Boolean updateCustomer(Customer customer){
        return customerMapper.updateCustomer(customer)==1;
    }


    public Boolean deleteCustomer(Integer uid) {
        if (customerMapper.getCustomerById(uid) == null){
            return false;
        }
        // 根据id查询账户表是否有记录，如果有记录就不能删除该条用户记录
        List<Account> accounts = accountMapper.getAccountByUid(uid);
        if (accounts != null){
            return false;
        }
        if (customerMapper.deleteCustomer(uid)==1){
            return true;
        }
        return false;
    }

}
