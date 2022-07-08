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
        // 新增用户进行非重复校验
        Customer customer1 = customerMapper.getCustomerByName(customer.getUname());
        if (customer1 != null){
            return false;
        }
        return customerMapper.insertCustomer(customer)==1;
    }

    public Boolean updateCustomer(Customer customer){
        // 修改用户进行非重复校验(仅可和自己重复)
        Customer customer1 = customerMapper.getCustomerByName(customer.getUname()); // 根据输入的名字去数据库查有没有相同客户名  有
        Customer customerById = customerMapper.getCustomerById(customer.getUid()); // 查询本条记录原有客户名  李小姐
        if (customer1 != null && (!customerById.getUname().equals(customer.getUname()))){
            return false;
        }
        return customerMapper.updateCustomer(customer)==1;
    }

    public Boolean deleteCustomer(Integer uid) {
        // 不直接在数据库使用联合查询，全在service进行相关的表查询
        // 具体校验的错误结果均可通过不同的status信息返回给前端

        // 记录的存在性校验
        if (customerMapper.getCustomerById(uid) == null){
            return false;
        }
        // 根据id查询账户表是否有记录，如果有记录就不能删除该条用户记录
        List<Account> accounts = accountMapper.getAccountByUid(uid);
        if (accounts.size() != 0){
            return false;
        }
        if (customerMapper.deleteCustomer(uid)==1){
            return true;
        }
        return false;
    }

}
