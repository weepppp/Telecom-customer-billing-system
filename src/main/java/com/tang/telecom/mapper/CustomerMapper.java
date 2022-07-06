package com.tang.telecom.mapper;

import com.tang.telecom.entity.Customer;

import java.util.List;

/**
 * @author weepppp 2022/7/6 19:16
 **/
public interface CustomerMapper {

    // 查询所有
    List<Customer> getCustomer();
}
