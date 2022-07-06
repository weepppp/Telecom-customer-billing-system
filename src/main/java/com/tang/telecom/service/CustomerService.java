package com.tang.telecom.service;

import com.tang.telecom.entity.Customer;
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

    public List<Customer> getCustomer(){
        return customerMapper.getCustomer();
    }
}
