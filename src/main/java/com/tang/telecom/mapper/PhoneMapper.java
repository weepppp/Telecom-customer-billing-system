package com.tang.telecom.mapper;

import com.tang.telecom.entity.Phone;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author weepppp 2022/7/7 8:12
 **/
public interface PhoneMapper {
    List<Phone> getPhone();

    Phone getPhoneById(@Param("pid")String pid);

    int insertPhone(Phone phone);

    int updatePhone(Phone phone);

    int deletePhone(@Param("pid")Long pid);

    List<Phone> getPhoneByAid(@Param("aid") String aid);

    Phone getPhoneByCall(@Param("phoneNumber") String phoneNumber);

}
