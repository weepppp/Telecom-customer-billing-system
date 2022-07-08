package com.tang.telecom.mapper;

import com.tang.telecom.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

/**
 * @author weepppp 2022/7/7 9:59
 **/
public interface UserMapper {
    User getByUsername(@Param("username") String username);


    Set<String> getUserPermissionByUsername(@Param("username") String username);

}
