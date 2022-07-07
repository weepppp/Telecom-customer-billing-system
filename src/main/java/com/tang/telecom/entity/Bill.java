package com.tang.telecom.entity;

import lombok.Data;

/**
 * @author weepppp 2022/7/7 18:23
 **/
@Data
public class Bill {
    private String bid;
    private String callNamber;
    private String calledNamber;
    private String callTime;
    private double callFee;
}
