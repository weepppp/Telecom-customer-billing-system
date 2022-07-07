package com.tang.telecom.service;

import com.tang.telecom.entity.Account;
import com.tang.telecom.entity.Fixedphone;
import com.tang.telecom.entity.Phone;
import com.tang.telecom.mapper.AccountMapper;
import com.tang.telecom.mapper.FixedphoneMapper;
import com.tang.telecom.mapper.PhoneMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author weepppp 2022/7/7 8:22
 **/
@Service
public class PhoneService {

    @Autowired
    AccountMapper accountMapper;

    @Autowired
    PhoneMapper phoneMapper;

    @Autowired
    FixedphoneMapper fixedphoneMapper;

    public List<Phone> getPhone(){
        return phoneMapper.getPhone();
    }

    public Boolean insertPhone(Phone phone) {
        // 根据业务需求，可以验证下新增或者更新的电话是否已存在
        // 查询固定电话表中是否已有该号码，账号表中是否有该账户，有才能录入
        Fixedphone fixedphone = fixedphoneMapper.getByFixedPhoneNumber(phone.getPhoneNumber());
        System.out.println(fixedphone);
        if (fixedphone == null){
            return false;
        }
        Account accountById = accountMapper.getAccountById(phone.getAid());
        if (accountById == null){
            return false;
        }
        return phoneMapper.insertPhone(phone)==1;
    }

    public Boolean updatePhone(Phone phone){
        // 同样查询固定电话表中是否已有该号码，账号表中是否有该账户，有才能修改
        Fixedphone fixedphone = fixedphoneMapper.getByFixedPhoneNumber(phone.getPhoneNumber());
        if (fixedphone == null){
            return false;
        }
        Account accountById = accountMapper.getAccountById(phone.getAid());
        if (accountById == null){
            return false;
        }
        return phoneMapper.updatePhone(phone)==1;
    }

    public Boolean deletePhone(Long pid) {
        if (phoneMapper.deletePhone(pid)==1){
            return true;
        }
        return false;
    }


}
