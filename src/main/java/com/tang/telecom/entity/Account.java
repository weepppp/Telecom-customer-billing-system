package com.tang.telecom.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author weepppp 2022/7/6 22:19
 **/
@Data
public class Account {
    private String aid;
    private Integer uid;
    private String bankAccount;
    @NotEmpty(message="主行不能为空！")
    private String openBank;
    private String subBank;
    private Long readyAmount;
    private Long costAmount;
    private Long curMonthAmount;
}
