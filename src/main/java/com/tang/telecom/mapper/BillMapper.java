package com.tang.telecom.mapper;

import com.tang.telecom.entity.Bill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weepppp 2022/7/7 18:28
 **/
public interface BillMapper {

    List<Bill> getAllBill();

    List<Bill> getAllByCallNumber(@Param("callNamber") String callNamber, @Param("calledNamber") String calledNamber);

    int insertBill(Bill bill);
}
