package com.tang.telecom.mapper;

import com.tang.telecom.entity.Fixedphone;
import org.apache.ibatis.annotations.Param;

/**
 * @author weepppp 2022/7/7 8:49
 **/
public interface FixedphoneMapper {

    Fixedphone getByFixedPhoneNumber(@Param("fixedPhoneNumber") String fixedPhoneNumber);
}
