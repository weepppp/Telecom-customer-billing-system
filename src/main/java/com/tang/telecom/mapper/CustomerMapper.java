package com.tang.telecom.mapper;

import com.tang.telecom.entity.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weepppp 2022/7/6 19:16
 **/
public interface CustomerMapper {

    // 查询所有
    List<Customer> getCustomer();
    // 根据id查询
    Customer getCustomerById(@Param("uid") Integer uid);
    // 增加
    int insertCustomer(Customer customer);
    // 修改
    int updateCustomer(Customer customer);
    // 删除
    int deleteCustomer(@Param("uid") Integer uid);

    Customer getCustomerByName(@Param("uname") String uname);

}
