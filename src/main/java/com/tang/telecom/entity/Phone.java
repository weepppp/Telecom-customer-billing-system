package com.tang.telecom.entity;

import lombok.Data;

/**
 * @author weepppp 2022/7/7 8:09
 **/
@Data
public class Phone {
    private Long pid;
    private String phoneNumber;
    private String phoneAddress;
    private String aid;
}
